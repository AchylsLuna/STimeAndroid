package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.yourapp.models.AuthResponse
import com.example.yourapp.models.User
import com.example.yourapp.network.RetrofitClient
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
        confirmPassword = findViewById(R.id.etConfirmPass)
        signUpBtn = findViewById(R.id.btnSignUp)

        signUpBtn.setOnClickListener {
            val id = studentId.text.toString().trim()
            val pass = password.text.toString().trim()
            val confirmPass = confirmPassword.text.toString().trim()

            if (id.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (pass != confirmPass) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            signUpUser(id, pass)
        }
    }

    private fun signUpUser(id: String, pass: String) {
        val user = User(id, pass)
        RetrofitClient.instance.signUpUser(user).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    Toast.makeText(this@SignupActivity, "Signup Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignupActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@SignupActivity, "Signup Failed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Toast.makeText(this@SignupActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
