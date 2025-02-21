package com.aman.retrofitapplication

class UserResponse : ArrayList<UserResponseItem>()


data class UserResponseItem(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String
)