package com.example.examenparcial2.data.remote.api

import com.example.examenparcial2.data.remote.dto.FrankfurterDto
import retrofit2.http.GET

interface FrankfurterApi {
    @GET("v2/rates?base=USD&quotes=EUR,BOB")
    suspend fun getExchangeRates(): FrankfurterDto
}
