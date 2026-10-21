package com.example.examenparcial2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos_table")
data class ProductoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val category: String,
    val priceUSD: Double,
    val priceBOB: Double,
    val thumbnailUrl: String
)
