package com.example.mvvmnewsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.model.NewsData
import com.example.mvvmnewsapp.network.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    fun getNews() : LiveData<ArrayList<Article>> {
        var newsResponse = MutableLiveData<ArrayList<Article>>()
        MyApi().getNews().enqueue(object: Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if(response.isSuccessful)
                    newsResponse.value = response.body()!!.articles as ArrayList<Article>
                }

                override fun onFailure(call: Call<NewsData>, t: Throwable) {
                    Log.d("fail", t.message.toString())
                }
        })

        return newsResponse

    }

}