package com.trackerr.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("signup") // Replace with your actual endpoint
    suspend fun signupUser(@Body request: SignupRequest): Response<ApiResponse>
}