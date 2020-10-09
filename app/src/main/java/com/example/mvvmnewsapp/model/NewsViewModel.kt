package com.example.mvvmnewsapp.model

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmnewsapp.NewsListener
import com.example.mvvmnewsapp.NewsRepository


class NewsViewModel : ViewModel() {
    var title: String? = null
    var description: String? = null
    var imgUrl: String? = null
    var newsListener: NewsListener? = null

    fun getArticles(view: View) {
        Log.d("NewsViewModel", "working")
        var news = NewsRepository().getNews()
        newsListener?.onSuccess(news)
        newsListener?.onFailure("Failed to get news")
    }



}