package com.example.examenparcial2.data.mapper

import com.example.examenparcial2.data.local.entity.PostEntity
import com.example.examenparcial2.data.remote.dto.PostDto

fun PostDto.toEntity(): PostEntity {
    return PostEntity(
        id = this.id,
        title = this.title,
        body = this.body
    )
}
