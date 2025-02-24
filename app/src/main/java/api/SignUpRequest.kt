package api

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



