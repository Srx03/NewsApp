package com.example.newsapp.main.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import com.example.newsapp.main.repository.NewsRepository

class NewsViewModelProviderFactory(val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}