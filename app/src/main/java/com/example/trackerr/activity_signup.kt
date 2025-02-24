package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import api.ApiInt
import api.SignupRequest
import api.ApiResponse
import com.example.trackerr.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_signup : AppCompatActivity() {
    private lateinit var studentId: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var signUpBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        studentId = findViewById(R.id.etID)
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPass)
        confirmPassword = findViewById(R.id.etConPass)
        signUpBtn = findViewById(R.id.btnSignUp)
        val signIn: TextView = findViewById(R.id.signintxt)

        signUpBtn.setOnClickListener {
            val id = studentId.text.toString().trim()
            val emailInput = email.text.toString().trim()
            val pass = password.text.toString().trim()
            val confirmPass = confirmPassword.text.toString().trim()

            if (id.isEmpty() || emailInput.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != confirmPass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            signUpUser(id, emailInput, pass, confirmPass)
        }

        signIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signUpUser(id: String, email: String, pass: String, confirmPass: String) {
        val signupRequest = SignupRequest(student_id = id, email = email, password = pass, confirm_password = confirmPass)
        val apiService = RetrofitClient.create(ApiInt::class.java)

        apiService.signUp("register", signupRequest).enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    if (apiResponse != null && apiResponse.success) {
                        Toast.makeText(this@activity_signup, "Setup your Scholarship Type", Toast.LENGTH_SHORT).show()
                        // Redirect to login screen
                        val intent = Intent(this@activity_signup, scholar_page::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@activity_signup, "Signup Failed: ${apiResponse?.message}", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    if (response.code() == 409) {
                        Toast.makeText(this@activity_signup, "Signup Failed: Student ID or Email already exists", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@activity_signup, "Signup Failed: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@activity_signup, "Signup failed: ${t.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        })
    }
}