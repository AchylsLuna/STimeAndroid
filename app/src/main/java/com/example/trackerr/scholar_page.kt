package com.example.trackerr

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class scholar_page : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scholar_page)

        // Adjust window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find Spinners
        val spinner1 = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)
        val spinner4 = findViewById<Spinner>(R.id.spinner4)
        val SignUp1 = findViewById<Button>(R.id.btnSignUp)


        // Fix: Move this inside onCreate
        SignUp1.setOnClickListener {
            startActivity(Intent(this, activity_dtr::class.java))
        }

        // Load spinner options from strings.xml
        val dutyStatusOptions = resources.getStringArray(R.array.duty_status_options).toList()
        val scholarTypeOptions = resources.getStringArray(R.array.scholar_type_options).toList()
        val courseOptions = resources.getStringArray(R.array.course_options).toList()
        val yearLevelOptions = resources.getStringArray(R.array.year_level_options).toList()

        // Function to set up the spinner with options
        fun setupSpinner(spinner: Spinner, options: List<String>) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Apply adapters
        setupSpinner(spinner1, dutyStatusOptions)
        setupSpinner(spinner2, scholarTypeOptions)
        setupSpinner(spinner3, courseOptions)
        setupSpinner(spinner4, yearLevelOptions)
    }
}

class activity_dtr {
}
