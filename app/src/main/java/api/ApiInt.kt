package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInt {
  @Headers("Content-type: application/json")
  @POST("php/register.php")

  fun SignUp(
    @Body Signup: SignupRequest
    ): Call<Void>
}
