package com.example.examenparcial2.data.mapper

import com.example.examenparcial2.data.local.entity.ProductoEntity
import com.example.examenparcial2.data.remote.dto.FrankfurterDto
import com.example.examenparcial2.data.remote.dto.ProductDto

fun ProductDto.toEntity(exchangeRate: FrankfurterDto): ProductoEntity {
    // Obtenemos la tasa de BOB, si falla usamos 6.96 por defecto
    val rateBOB = exchangeRate.rates["BOB"] ?: 6.96 
    
    return ProductoEntity(
        id = this.id,
        title = this.title,
        category = this.category,
        priceUSD = this.price,
        priceBOB = this.price * rateBOB, // Aquí unimos la data de ambas APIs
        thumbnailUrl = this.thumbnail
    )
}
