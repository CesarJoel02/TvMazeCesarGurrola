package com.cesar.gurrola.tvmaze.presentation.utils

import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModelItem

interface onTvShowClickListener {
    fun onTvShowClickListener(item : TvShowsListDataModelItem)
}