package com.aman.retrofitapplication

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitInstance {
    //loggin interceptor to get logs in the logcat
    val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder().addInterceptor(logging).build()

    val api : RetrofitInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RetrofitInterface::class.java)
    }
}

interface RetrofitInterface {
    @GET("users")
    fun getUsers() : Call<ArrayList<UserResponseItem>>
}
