package com.example.retrofit2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit2.Model.Article
import com.example.retrofit2.Model.News
import com.example.retrofit2.R
import kotlinx.android.synthetic.main.item_news.view.*
import java.util.ArrayList

class NewsAdapter(var newsList:List<Article>):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun bind(news: Article){
            itemView.txtTitle.text=news.title
            itemView.txtContent.text=news.content
            Glide.with(itemView).load(news.urlToImage).into(itemView.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false))
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }
}