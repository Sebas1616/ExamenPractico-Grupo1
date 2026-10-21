package com.example.examenparcial2.data.repository

import com.example.examenparcial2.data.local.dao.ProductoDao
import com.example.examenparcial2.data.local.entity.ProductoEntity
import com.example.examenparcial2.data.mapper.toEntity
import com.example.examenparcial2.data.remote.api.DummyJsonApi
import com.example.examenparcial2.data.remote.api.FrankfurterApi

class ProductRepository(
    private val dummyApi: DummyJsonApi,
    private val frankfurterApi: FrankfurterApi,
    private val productoDao: ProductoDao
) {
    suspend fun fetchAndSaveProducts(): List<ProductoEntity> {
        // 1. Descargamos la data de ambas APIs
        val productsResponse = dummyApi.getProducts()
        val exchangeRate = frankfurterApi.getExchangeRates()

        // 2. El Mapper hace su magia: une los datos y calcula el precio en BOB
        val entities = productsResponse.products.map { it.toEntity(exchangeRate) }

        // 3. Guardamos directo en Room (sin cache complejo)
        productoDao.insertAll(entities)

        // 4. Devolvemos la lista lista para usar en la UI
        return entities
    }
}
