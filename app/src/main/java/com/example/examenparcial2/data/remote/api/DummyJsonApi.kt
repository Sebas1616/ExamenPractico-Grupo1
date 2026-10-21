package com.example.examenparcial2.data.remote.api

import com.example.examenparcial2.data.remote.dto.ProductResponseDto
import retrofit2.http.GET

interface DummyJsonApi {
    @GET("products")
    suspend fun getProducts(): ProductResponseDto
}
