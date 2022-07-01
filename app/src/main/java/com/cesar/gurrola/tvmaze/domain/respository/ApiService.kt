package com.cesar.gurrola.tvmaze.domain.respository

import com.cesar.gurrola.tvmaze.domain.models.TvShowCastModel
import com.cesar.gurrola.tvmaze.domain.models.TvShowDetailModel
import com.cesar.gurrola.tvmaze.domain.models.TvShowsListDataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/schedule")
    fun getTvShowsList(
        @Query("country")country: String,
        @Query("date")date: String,
    ): Observable<TvShowsListDataModel>

    @GET("/search/shows")
    fun getTvShow(
        @Query("q")q: String
    ): Observable<TvShowsListDataModel>

    @GET("shows/{id}")
    fun getShowDetail(
        @Path("id") id : Int
    ): Observable<TvShowDetailModel>

    @GET("shows/{id}/cast")
    fun getTvShowCast(
        @Path("id")id: Int
    ): Observable<TvShowCastModel>

}