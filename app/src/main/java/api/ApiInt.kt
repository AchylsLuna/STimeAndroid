package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInt {
  @Headers("Content-type: application/json")
  @POST("php/api.php")
  fun signUp(
    @Query("action") action: String = "register",
    @Body request: SignupRequest
  ): Call<ApiResponse>

  @POST("type.php")
  fun type(@Body request: ScholarSelectionRequest): Call<Void>
}