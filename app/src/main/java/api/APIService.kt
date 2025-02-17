package api

import com.example.trackerr.AuthResponse
import com.example.trackerr.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun loginUser(@Body user: User): Call<AuthResponse>

    @POST("signup")
    fun signUpUser(@Body user: User): Call<AuthResponse>
}
