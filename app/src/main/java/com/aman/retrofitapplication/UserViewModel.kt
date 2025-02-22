package com.aman.retrofitapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    var userList: MutableLiveData<ArrayList<UserResponseItem>> = MutableLiveData(arrayListOf())

    fun getUser(){
        RetrofitInstance.api.getUsers().enqueue(object: Callback<ArrayList<UserResponseItem>>{
            override fun onResponse(
                call: Call<ArrayList<UserResponseItem>>,
                response: Response<ArrayList<UserResponseItem>>
            ) {
                Log.e("TAG", " in success ${response.body()}")
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<UserResponseItem>>, t: Throwable) {
                Log.e("TAG", " in failure ${t.message}")
            }

        })
    }
}