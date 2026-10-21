package com.example.examenparcial2.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.examenparcial2.data.local.entity.PostEntity

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostEntity>): @JvmSuppressWildcards List<Long>

    @Query("SELECT * FROM posts_table")
    suspend fun getAllPosts(): @JvmSuppressWildcards List<PostEntity>
}
