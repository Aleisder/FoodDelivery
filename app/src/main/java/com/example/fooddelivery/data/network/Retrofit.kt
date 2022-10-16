package com.example.fooddelivery.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private const val BASE_URL = "https://burgers1.p.rapidapi.com"

    val BurgersApi: BurgersApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BurgersApiService::class.java)
    }
}