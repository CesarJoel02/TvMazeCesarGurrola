package com.cesar.gurrola.tvmaze

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModelItem
import com.cesar.gurrola.tvmaze.presentation.utils.onTvShowClickListener



class TvMazeDetailFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_maze_detail, container, false)
    }

}