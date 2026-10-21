package com.example.examenparcial2.data.repository

import com.example.examenparcial2.data.local.dao.PostDao
import com.example.examenparcial2.data.local.entity.PostEntity
import com.example.examenparcial2.data.mapper.toEntity
import com.example.examenparcial2.data.remote.api.JsonPlaceholderApi

class PostRepository(
    private val jsonPlaceholderApi: JsonPlaceholderApi,
    private val postDao: PostDao
) {
    suspend fun fetchAndSavePosts(): List<PostEntity> {
        // Descargamos de API 3, mapeamos y guardamos directo
        val posts = jsonPlaceholderApi.getPosts()
        val entities = posts.map { it.toEntity() }
        postDao.insertAll(entities)
        return entities
    }
}
