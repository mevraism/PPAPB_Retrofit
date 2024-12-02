package com.example.ppapb_retrofit.network

import com.example.ppapb_retrofit.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users?page=2")
    fun getallusers(): Call<Users>
}