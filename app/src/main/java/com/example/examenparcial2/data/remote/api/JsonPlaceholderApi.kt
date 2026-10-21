package com.example.examenparcial2.data.remote.api

import com.example.examenparcial2.data.remote.dto.PostDto
import retrofit2.http.GET

interface JsonPlaceholderApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
