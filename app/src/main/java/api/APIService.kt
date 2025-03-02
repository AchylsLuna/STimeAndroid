package com.example.trackerr.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Field

interface APIService {
  @FormUrlEncoded
  @POST("login.php")
  fun login(
    @Field("username") username: String,
    @Field("password") password: String
  ): Call<ResponseBody>

  @FormUrlEncoded
  @POST("submit_time.php")
  fun submitTime(
    @Field("user_id") userId: Int,
    @Field("date") date: String,
    @Field("time_in") timeIn: String,
    @Field("time_out") timeOut: String
  ): Call<ResponseBody>
}


