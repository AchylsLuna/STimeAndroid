package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class activity_signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnSignUp = findViewById<Button>(R.id.btnsignUp)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, scholar_page::class.java)
            startActivity(intent)
        }
    }
}
