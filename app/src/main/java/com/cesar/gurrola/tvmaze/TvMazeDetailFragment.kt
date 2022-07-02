package com.cesar.gurrola.tvmaze

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.scale
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesar.gurrola.tvmaze.databinding.FragmentTvMazeDetailBinding
import com.cesar.gurrola.tvmaze.domain.models.TvShowCastModel
import com.cesar.gurrola.tvmaze.domain.models.TvShowDetailModel
import com.cesar.gurrola.tvmaze.domain.respository.ApiClient
import com.cesar.gurrola.tvmaze.presentation.talento.TalentoAdapter
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class TvMazeDetailFragment : Fragment() {

    private var _binding : FragmentTvMazeDetailBinding ?= null
    private val binding get() = _binding!!
    private var myCompositeDisposable: CompositeDisposable? = null
    private lateinit var adapter : TalentoAdapter
    private var showId = 0
    private var showUrl = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTvMazeDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            arguments?.let {
                it.getInt("id")?.let { id ->
                    showId = id
                    fetchData(showId)
                }
                it.getString("url")?.let { url ->
                    showUrl = url
                }
            }
        }

        binding.btnVisitarSitio.setOnClickListener {
            if (showId != 0){
                navigateToShowUrl(showId)
            }
        }



        return binding.root
    }

    private fun navigateToShowUrl(showId: Int) {
        if (showUrl != "") {
            startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse(showUrl))
            )
        }
    }

    fun fetchData(id: Int){
        val req = ApiClient().provideTvShowListService().getShowDetail(id)
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

    fun handleData(tvShow : TvShowDetailModel) {

        val genres = tvShow.genres.joinToString(", ")
        Picasso.get().load(tvShow.image.medium).into(binding.imageTvShow)
        binding.textTvShowName.text = tvShow.name
        binding.textTvShowNetworkName.text = tvShow.network.name
        binding.textTitleSinopsisDesc.text = Html.fromHtml(tvShow.summary, Html.FROM_HTML_MODE_COMPACT)
        binding.textValueGenre.text = genres
        binding.textTitleHorario.text = spannableString(tvShow)
        binding.textTvShowNetworkRating.text = getString(R.string.text_rating_placeholder, tvShow.rating.average.toString())
        getTalentos(tvShow.id)
    }

    fun spannableString (tvShow : TvShowDetailModel) : SpannableStringBuilder{
        val time = tvShow.schedule.time
        val days =  tvShow.schedule.days.joinToString(", ")
        val spannable = SpannableStringBuilder()
            .bold { scale(1f, {append("Horarios: ")}) }
            .append(time)
            .append(" | ")
            .append(days)
        return spannable
    }

    fun getTalentos(id : Int){
        val req = ApiClient().provideTvDetailService().getTvShowCast(id)
        CompositeDisposable()?.add(
            req.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { Log.e("Error", "${it.localizedMessage}") }
                .subscribe(this::initRecyclertalentos)
                {t: Throwable -> Log.e("TalentosList", "error : ${t.localizedMessage}")}
        )
    }

    fun initRecyclertalentos(talentos : TvShowCastModel){
        adapter = TalentoAdapter(talentos)
        Log.d("Talentos", talentos.toString())
        binding.recycerTalentos.adapter = adapter
        binding.recycerTalentos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}