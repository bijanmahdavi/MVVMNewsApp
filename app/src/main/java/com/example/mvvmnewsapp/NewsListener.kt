package com.example.mvvmnewsapp

import androidx.lifecycle.LiveData
import com.example.mvvmnewsapp.model.Article

interface NewsListener {
    fun onStarted()
    fun onSuccess(response: LiveData<ArrayList<Article>>)
    fun onFailure(message: String)
}