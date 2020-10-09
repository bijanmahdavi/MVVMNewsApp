package com.example.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvmnewsapp.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmnewsapp.adapter.NewsListViewAdapter
import com.example.mvvmnewsapp.model.Article
import com.example.mvvmnewsapp.model.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsListener {

    lateinit var mBinding: ActivityMainBinding
    var mList: ArrayList<Article> = ArrayList()
    private var newsAdapter: NewsListViewAdapter? =  null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()
    }

    private fun init() {

        // with viewModel and Live data
        var myViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        mBinding.userInfo = myViewModel
        myViewModel.newsListener = this

        newsAdapter = NewsListViewAdapter(this, mList)
        RV.layoutManager = LinearLayoutManager(this)
        RV.adapter = newsAdapter

    }

    override fun onStarted() {
        Log.d("MainActivity", "fetching news..")
    }

    override fun onSuccess(response: LiveData<ArrayList<Article>>) {
        response.observe(this, Observer {
            Log.d("MA - news", it.toString())
            newsAdapter?.setData(it)
        })
    }

    override fun onFailure(message: String) {
        //
    }
}