package com.example.trackerr

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        private val apiService = RetrofitClient.instance

        val studentId = findViewById<EditText>(R.id.studentId)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val edtConPassword = findViewById<EditText>(R.id.edtConPassword)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val btnSignup = findViewById<Button>(R.id.button2)

        btnSignup.setOnClickListener {
            val studentIdText = studentId.text.toString().trim()
            val emailText = edtEmail.text.toString().trim()
            val passwordText = edtPassword.text.toString().trim()
            val confirmPasswordText = edtConPassword.text.toString().trim()
            val isChecked = checkBox.isChecked

            if (studentIdText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty() || confirmPasswordText.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (passwordText != confirmPasswordText) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isChecked) {
                Toast.makeText(this, "You must agree to the terms", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Proceed with signup logic (e.g., send data to API or save to database)
            Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()
        }
    }
}
