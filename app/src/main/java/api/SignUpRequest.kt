package api

class SignUpRequest {
}
data class SignupRequest(
    val studentId: String,
    val email: String,
    val password: String
)

// ApiResponse.kt
data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: UserData? = null
)

data class UserData(
    val id: String,
    val email: String
)