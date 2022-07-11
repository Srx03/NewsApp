package com.example.newsapp.main.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.main.models.Article


@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticels():LiveData<List<Article>>


}