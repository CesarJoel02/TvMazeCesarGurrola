package com.cesar.gurrola.tvmaze.domain.models

data class TvShowLinksModel( val nextepisode: TvShowNetxEpisodeModel,
                             val previousepisode: TvShowPreviousEpisodeModel,
                             val self: TvShowSelfModel)
