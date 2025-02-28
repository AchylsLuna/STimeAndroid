package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var studentId: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentId = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.signInbtn)

        loginBtn.setOnClickListener {
            val id = studentId.text.toString().trim()
            val pass = password.text.toString().trim()

            if (id.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Handle login logic here (if needed)
            Toast.makeText(this, "Login clicked!", Toast.LENGTH_SHORT).show()
        }

        val forgotBtn = findViewById<TextView>(R.id.forgotbtn)
        forgotBtn.setOnClickListener {
            loadFragment(forgotPass())
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, forgotPass())
            .commit()

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // Ensure you have a FrameLayout in activity_main.xml
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
