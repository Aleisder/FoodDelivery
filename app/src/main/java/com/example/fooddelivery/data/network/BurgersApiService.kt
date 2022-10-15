package com.example.fooddelivery.data.network

import com.example.fooddelivery.data.Burgers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://burgers1.p.rapidapi.com"

interface BurgersApiService {
    @Headers(
        "X-RapidAPI-Key: 25e45bb133msh33998e97aa4e05ap1cdd22jsnea6b560cb80d",
        "X-RapidAPI-Host: burgers1.p.rapidapi.com"
    )
    @GET("/burgers")
    suspend fun getBurgers(): Burgers
}

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object BurgersApi {
    val retrofitService: BurgersApiService by lazy {
        retrofit.create(BurgersApiService::class.java)
    }
}