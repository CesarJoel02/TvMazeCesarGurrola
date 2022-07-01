package com.cesar.gurrola.tvmaze.domain.models

class TvShowsListDataModel : ArrayList<TvShowsListDataModelItem>()

data class TvShowsListDataModelItem(
    val _links: TvShowLinksModel,
    val airdate: String,
    val airstamp: String,
    val airtime: String,
    val id: Int,
    val image: TvShowImageModel,
    val name: String,
    val number: Int,
    val rating: TvShowRatingModel,
    val runtime: Int,
    val season: Int,
    val show: TVShowModel,
    val summary: String,
    val type: String,
    val url: String
)