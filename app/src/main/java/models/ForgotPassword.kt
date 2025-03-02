package com.example.trackerr

data class ForgotPassword(
    val email: String,
    val verificationCode: String? = null
)
