package com.example.examenparcial2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
)
