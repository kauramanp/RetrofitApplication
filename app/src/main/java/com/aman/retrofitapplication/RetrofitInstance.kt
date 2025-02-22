package com.aman.retrofitapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitInstance {
    val api : RetrofitInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface::class.java)
    }
}

interface RetrofitInterface {
    @GET("users")
    fun getUsers() : Call<ArrayList<UserResponseItem>>
}
