package com.cesar.gurrola.tvmaze.domain.models

data class TvShowNetworkModel(
    val country: TvShowCountryModel,
    val id: Int,
    val name: String,
    val officialSite: String
)
