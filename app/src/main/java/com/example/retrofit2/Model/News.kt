package com.example.retrofit2.Model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)