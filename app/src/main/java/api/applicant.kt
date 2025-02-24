package com.trackerr.api

data class SignupRequest(
    val student_id: String,
    val email: String,
    val password: String,
    val confirm_password: String
)
