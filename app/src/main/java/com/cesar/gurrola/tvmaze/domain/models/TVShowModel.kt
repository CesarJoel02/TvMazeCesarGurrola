package com.cesar.gurrola.tvmaze.domain.models

data class TVShowModel(
    val _links: TvShowLinksModel,
    val averageRuntime: Int,
    val dvdCountry: Any,
    val ended: String,
    val externals: TvShowExternalsModel,
    val genres: List<String>,
    val id: Int,
    val image: TvShowImageModel,
    val language: String,
    val name: String,
    val network: TvShowNetworkModel,
    val officialSite: String,
    val premiered: String,
    val rating: TvShowRatingModel,
    val runtime: Int,
    val schedule: TvShowScheduleModel,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
    val webChannel: Any,
    val weight: Int
)