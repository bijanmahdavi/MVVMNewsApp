package com.example.mvvmnewsapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmnewsapp.R
import com.example.mvvmnewsapp.databinding.NewsListBinding
import com.example.mvvmnewsapp.model.Article
import kotlinx.android.synthetic.main.news_list.view.*

class NewsListViewAdapter(var mContext: Context, var mList: ArrayList<Article>) : RecyclerView.Adapter<NewsListViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsListBinding.inflate(inflater)
        //var view = LayoutInflater.from(mContext).inflate(R.layout.news_list, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(lst: ArrayList<Article>) {
        mList = lst
        notifyDataSetChanged()
    }

    inner class MyViewHolder(mBinding: NewsListBinding) : RecyclerView.ViewHolder(mBinding.root){
        fun bind(data: Article) {
            itemView.text_view_title.text = data.title
            itemView.text_view_description.text = data.description
            itemView.text_view_url.text = data.url
            itemView.setOnClickListener {
                Log.d("Article Clicked:", data.title)
            }

        }
    }
}