package com.example.retrofit2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.API.NewsInterface
import com.example.retrofit2.Adapter.NewsAdapter
import com.example.retrofit2.Model.Article
import com.example.retrofit2.Model.News
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }
    fun getNews(){
        var BASE_URL="http://newsapi.org/v2/"
        var retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var retrofitService=retrofit.create(NewsInterface::class.java)
        var apiCall = retrofitService.getNews("us","business","94464c2792e046b4b12d31eecc712a3a")
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                var newsList=response.body()?.articles
                Log.d("Response>>>>>",newsList.toString())
               val newsAdapter=NewsAdapter(newsList!!)
                RecyclerNews.apply {
                    layoutManager=LinearLayoutManager(context)
                    adapter=newsAdapter
                }
            }

        })
    }
}

