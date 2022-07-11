package com.example.newsapp.main.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.main.models.Article


@Database(entities = [Article::class], version = 1)
@TypeConverters(TypeConvertors::class)
abstract class ArticleDatabase: RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    companion object{
        @Volatile
       private var INSTANCE: ArticleDatabase? = null
        private var LOCK = Any()

       operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK){
           INSTANCE ?: createDatabase(context).also { INSTANCE = it}
       }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            "article.db"
        ).build()

    }
}