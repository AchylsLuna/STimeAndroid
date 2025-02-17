package com.example.trackerr


data class AuthResponse(
    val success: Boolean,
    val message: String,
    val data: UserData? = null
)

data class UserData(
    val id: String,
    val email: String
)


