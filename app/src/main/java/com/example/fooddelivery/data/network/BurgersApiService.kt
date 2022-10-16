package com.example.fooddelivery.data.network

import com.example.fooddelivery.data.Burger
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface BurgersApiService {
    @Headers(
        "X-RapidAPI-Key: 25e45bb133msh33998e97aa4e05ap1cdd22jsnea6b560cb80d",
        "X-RapidAPI-Host: burgers1.p.rapidapi.com"
    )
    @GET("/burgers")
    suspend fun getBurgers(): Response<List<Burger>>
}