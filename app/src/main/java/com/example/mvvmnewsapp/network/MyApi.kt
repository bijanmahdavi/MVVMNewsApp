package com.example.mvvmnewsapp.network

import com.example.mvvmnewsapp.app.Config
import com.example.mvvmnewsapp.model.NewsData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
//
//http://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=36a3d3a1d7cb428aba2bc96593195ffc
    @GET("top-headlines?country=us&category=business&apiKey=36a3d3a1d7cb428aba2bc96593195ffc")
    fun getNews(): Call<NewsData>

    companion object{
        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}