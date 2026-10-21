package com.example.examenparcial2.data.remote.dto

data class FrankfurterDto(
    val amount: Double,
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
