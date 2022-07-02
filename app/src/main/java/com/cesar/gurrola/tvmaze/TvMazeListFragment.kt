package com.cesar.gurrola.tvmaze

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesar.gurrola.tvmaze.databinding.FragmentTvMazeListBinding
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModel
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModelItem
import com.cesar.gurrola.tvmaze.domain.respository.ApiClient
import com.cesar.gurrola.tvmaze.presentation.tvShow.TvShowAdapter
import com.cesar.gurrola.tvmaze.presentation.utils.onTvShowClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


private const val DATE_FORMAT = "yyyy-mm-dd"


class TvMazeListFragment : Fragment(), onTvShowClickListener {


    private var _binding : FragmentTvMazeListBinding? = null
    private val binding get() = _binding!!
    private var myCompositeDisposable: CompositeDisposable? = null
    private var tvShowsAdapter : TvShowAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvMazeListBinding.inflate(inflater, container, false)
        fetchData()
        return binding.root
    }

    override fun onTvShowClickListener(item: TvShowsListDataModelItem) {
        if (item.show.id != null) {
            val bundle  = Bundle()
            bundle.putInt("id",item.show.id)
            bundle.putString("url", item.show.officialSite)
            findNavController().navigate(R.id.action_fragment_tvShowList_to_fragment_tvShowDetail, bundle)
        }
    }

    fun fetchData(){
        val req = ApiClient().provideTvShowListService().getTvShowsList("US", "2022-06-21")
        myCompositeDisposable = CompositeDisposable()
        myCompositeDisposable?.add(
            req
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { Log.e("Error", "${it.localizedMessage}") }
                .subscribe(this::handleData)
                {t: Throwable -> Log.e("DataList", "error : ${t.localizedMessage}")}
        )

    }

    fun handleData(tvShowList : TvShowsListDataModel){
        tvShowsAdapter = TvShowAdapter(tvShowList, this)
        binding.recyclerTvShowList.adapter = tvShowsAdapter
        binding.recyclerTvShowList.layoutManager = LinearLayoutManager(requireContext())
    }
}