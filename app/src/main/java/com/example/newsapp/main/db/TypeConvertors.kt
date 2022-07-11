package com.example.newsapp.main.db

import androidx.room.TypeConverter

import com.example.newsapp.main.models.Source

class TypeConvertors {


    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}