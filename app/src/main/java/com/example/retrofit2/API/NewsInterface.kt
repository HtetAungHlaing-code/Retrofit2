package com.example.retrofit2.API

import com.example.retrofit2.Model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("top-headlines")
    fun getNews(
        @Query("country")country:String,
        @Query("category")category:String,
        @Query("apiKey")apiKey:String
    ): Call<News>
}