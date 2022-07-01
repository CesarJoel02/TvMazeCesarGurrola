package com.cesar.gurrola.tvmaze.domain.models

class TvShowCastModel : ArrayList<TvShowCastModelItem>()

data class TvShowCastModelItem(
    val character: Character,
    val person: Person,
    val self: Boolean,
    val voice: Boolean
)

data class Character(
    val _links: TvShowLinksModel,
    val id: Int,
    val image: TvShowImageModel,
    val name: String,
    val url: String
)

data class Person(
    val _links: TvShowLinksModel,
    val birthday: String,
    val country: TvShowCountryModel,
    val deathday: Any,
    val gender: String,
    val id: Int,
    val image: TvShowImageModel,
    val name: String,
    val updated: Int,
    val url: String
)
