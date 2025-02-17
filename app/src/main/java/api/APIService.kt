package com.example.trackerr.network

import com.example.yourapp.models.AuthResponse
import com.example.yourapp.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun loginUser(@Body user: User): Call<AuthResponse>

    @POST("signup")
    fun signUpUser(@Body user: User): Call<AuthResponse>
}
