package com.example.mobileapp26

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class scholar_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scholar_page)
        val spinner1: Spinner = findViewById(R.id.spinner)  // Type of Scholarship
        val spinner2: Spinner = findViewById(R.id.spinner2) // Duty Status
        val spinner3: Spinner = findViewById(R.id.spinner3) // Schedule
        val spinner4: Spinner = findViewById(R.id.spinner4) // Expert Teacher
        val spinner5: Spinner = findViewById(R.id.spinner5) // Subject Code
        val button: Button = findViewById(R.id.button)

        // Data for each spinner
        val scholarshipTypes = listOf("hk25", "hk50", "hk75")
        val dutyStatuses = listOf("BBBS", "External Faci", "Faci Pool", "Internal Faci")
        val schedules = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        val expertTeachers = listOf("Joe Doe", "Jane Doe")
        val subjectCodes = listOf("ITE 393", "ITE 400")

        // Function to create and set adapter for a spinner
        fun setupSpinner(spinner: Spinner, items: List<String>) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        // Assign adapters to spinners
        setupSpinner(spinner1, scholarshipTypes)
        setupSpinner(spinner2, dutyStatuses)
        setupSpinner(spinner3, schedules)
        setupSpinner(spinner4, expertTeachers)
        setupSpinner(spinner5, subjectCodes)

        // Button click listener
        button.setOnClickListener {
            val selectedValues = """
                Scholarship Type: ${spinner1.selectedItem}
                Duty Status: ${spinner2.selectedItem}
                Schedule: ${spinner3.selectedItem}
                Expert Teacher: ${spinner4.selectedItem}
                Subject Code: ${spinner5.selectedItem}
            """.trimIndent()

            // Show selected values in a Toast message
            Toast.makeText(this, selectedValues, Toast.LENGTH_LONG).show()
        }
    }
}