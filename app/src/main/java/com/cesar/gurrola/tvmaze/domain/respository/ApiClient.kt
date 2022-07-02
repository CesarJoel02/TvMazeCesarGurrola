package com.cesar.gurrola.tvmaze.domain.respository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.tvmaze.com/"

class ApiClient {

    private val apiClient by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun provideTvShowListService(): ApiService{
        return apiClient.create(ApiService::class.java)
    }

    fun provideTvDetailService(): ApiService {
        return apiClient.create(ApiService::class.java)
    }


}