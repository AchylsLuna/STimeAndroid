package api

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

data class SignupRequest(
    val student_id: String,
    val email: String,
    val password: String,
    val confirm_password: String
)

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: UserData? = null
)

data class UserData(
    val id: String,
    val email: String
)


