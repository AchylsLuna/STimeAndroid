package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerr.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var signInBtn: Button
    private lateinit var signUpText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        signInBtn = findViewById(R.id.signInbtn)
        signUpText = findViewById(R.id.signUpbtn)

        signInBtn.setOnClickListener {
            val studentId = username.text.toString().trim()
            val pass = password.text.toString().trim()

            if (studentId.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // loginUser(studentId, pass)
        }

        signUpText.setOnClickListener {
            startActivity(Intent(this, activity_signup::class.java)) // Use correct class name
        }
        // Fixed class reference
        }
    }

