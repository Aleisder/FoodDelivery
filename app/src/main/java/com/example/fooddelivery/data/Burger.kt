package com.example.fooddelivery.data

data class Burger(
    val addresses: List<Addresse>,
    val description: String,
    val id: Int,
    val ingredients: List<String>,
    val name: String,
    val restaurant: String,
    val web: String
)