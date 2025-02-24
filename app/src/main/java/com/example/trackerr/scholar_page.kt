package com.example.trackerr

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import api.ApiInt
import com.example.trackerr.api.ApiService
import com.example.trackerr.api.ScholarSelectionRequest
import com.example.trackerr.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        val signUpButton = findViewById<Button>(R.id.btnSignUp)

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

        // Handle sign up button click
        signUpButton.setOnClickListener {
            val selectedDutyStatus = spinner1.selectedItem.toString()
            val selectedScholarType = spinner2.selectedItem.toString()
            val selectedCourse = spinner3.selectedItem.toString()
            val selectedYearLevel = spinner4.selectedItem.toString()

            val studentId = "12345" // Replace with actual student ID

            val request = ScholarSelectionRequest(
                student_id = studentId,
                duty_status = selectedDutyStatus,
                scholar_type = selectedScholarType,
                course = selectedCourse,
                year_level = selectedYearLevel
            )

            val apiService = RetrofitClient.create(ApiInt::class.java)
            apiService.type(request).enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.isSuccessful) {
                        Toast.makeText(this@scholar_page, "Selection updated successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@scholar_page, activity_dtr::class.java))
                    } else {
                        Toast.makeText(this@scholar_page, "Failed to update selection", Toast.LENGTH_SHORT).show()
                    }
                }

                object activity_dtr {

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(this@scholar_page, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}