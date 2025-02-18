package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import api.ApiInt
import api.SignupRequest
import com.example.trackerr.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_signup : AppCompatActivity() {
    private lateinit var studentId: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var signUpBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        studentId = findViewById(R.id.etID)
        password = findViewById(R.id.etPass)
        confirmPassword = findViewById(R.id.etConPass)
        signUpBtn = findViewById(R.id.button2)
        var email: EditText = findViewById(R.id.etEmail)
        signUpBtn.setOnClickListener {
            val id = studentId.text.toString().trim()
            val pass = password.text.toString().trim()
            val confirmPass = confirmPassword.text.toString().trim()
            var emailInput = email.text.toString().trim()

            if (id.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != confirmPass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            signUpUser(id, pass, confirmPass, emailInput)
        }
    }

    private fun signUpUser(id: String, pass: String, confirm_pass: String, email: String) {
        val signup = SignupRequest(
            student_id = id,
            password = pass,
            confirm_password = confirm_pass,
            email = email
        )
        val apiService = RetrofitClient.create(ApiInt::class.java)

        apiService.SignUp("register", signup).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@activity_signup, "Signup Successful", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@activity_signup, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        this@activity_signup,
                        "Signup Failed: ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // Implement a proper failure handler
                Toast.makeText(this@activity_signup, "Error: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
                t.printStackTrace()  // Log the error stack trace for debugging
            }
        })
    }
}