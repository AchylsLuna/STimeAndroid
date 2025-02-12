package com.example.mobileapp26

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Signup : AppCompatActivity() {

    private lateinit var editTextSid: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSignup: Button
    private lateinit var checkBoxTerms: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup) // Replace with your XML layout file name

        // Initialize UI components
        editTextSid = findViewById(R.id.editTextText)
        editTextPassword = findViewById(R.id.editTextText2)
        editTextConfirmPassword = findViewById(R.id.editTextText3)
        editTextEmail = findViewById(R.id.editTextText4)
        buttonSignup = findViewById(R.id.button2)
        checkBoxTerms = findViewById(R.id.checkBox)

        // Set up the signup button click listener
        buttonSignup.setOnClickListener {
            // Validate user input
            if (validateInput()) {
                Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to validate user input
    private fun validateInput(): Boolean {
        val sid = editTextSid.text.toString().trim()
        val password = editTextPassword.text.toString().trim()
        val confirmPassword = editTextConfirmPassword.text.toString().trim()
        val email = editTextEmail.text.toString().trim()

        if (sid.isEmpty()) {
            editTextSid.error = "Student ID is required"
            return false
        }

        if (password.isEmpty()) {
            editTextPassword.error = "Password is required"
            return false
        }

        if (confirmPassword.isEmpty()) {
            editTextConfirmPassword.error = "Confirm Password is required"
            return false
        }

        if (password != confirmPassword) {
            editTextConfirmPassword.error = "Passwords do not match"
            return false
        }

        if (email.isEmpty()) {
            editTextEmail.error = "Email is required"
            return false
        }

        if (!checkBoxTerms.isChecked) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}