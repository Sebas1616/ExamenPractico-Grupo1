package com.example.examenparcial2.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenparcial2.data.local.entity.ProductoEntity

@Dao
interface ProductoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(productos: List<ProductoEntity>): @JvmSuppressWildcards List<Long>

    @Query("SELECT * FROM productos_table")
    suspend fun getAllProductos(): @JvmSuppressWildcards List<ProductoEntity>
}
