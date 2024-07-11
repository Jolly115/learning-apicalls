package com.example.apicalls.network

import com.example.apicalls.model.PeopleItems
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    companion object{
        fun getApiService():ApiService{
            val loggingInterceptor =HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

            //Client
            val lcient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            //Retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com/russellbstephens/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(lcient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }


    @GET("9e528b12fd1a45a7ff4e4691adcddf10/raw/5ec8ce76460e8f29c9b0f99f3bf3450b06696482/people.json")
   suspend fun
            getPeoples():Response<PeopleItems>
}