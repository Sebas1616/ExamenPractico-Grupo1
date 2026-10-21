package com.example.examenparcial2.data.remote.dto

data class ProductResponseDto(
    val products: List<ProductDto>
)

data class ProductDto(
    val id: Int,
    val title: String,
    val category: String,
    val price: Double,
    val thumbnail: String
)
