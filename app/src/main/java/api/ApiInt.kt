package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInt {
  @Headers("Content-type: application/json")
  @POST("register.php")

  fun SignUp(
    @Query("action") route: String = "register",
    @Body Signup: SignupRequest

    ): Call<Void>
}
