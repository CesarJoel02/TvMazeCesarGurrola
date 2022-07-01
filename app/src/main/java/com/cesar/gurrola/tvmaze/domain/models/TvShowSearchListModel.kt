package com.cesar.gurrola.tvmaze.domain.models

class TvShowSearchListModel : ArrayList<TvShowSearchListModelItem>()

data class TvShowSearchListModelItem(
    val score: Double,
    val show: TVShowModel
)