package com.example.examenparcial2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examenparcial2.data.local.entity.PostEntity
import com.example.examenparcial2.data.local.entity.ProductoEntity
import com.example.examenparcial2.data.local.dao.ProductoDao
import com.example.examenparcial2.data.local.dao.PostDao

@Database(entities = [ProductoEntity::class, PostEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun postDao(): PostDao
}
