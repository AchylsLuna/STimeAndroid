package com.example.trackerr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Find views by ID
        val profileName = findViewById<TextView>(R.id.profileName)
        val profileDetails = findViewById<EditText>(R.id.profileDetails)
        val profileActivity = findViewById<EditText>(R.id.profileActivity)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Example user profile data (replace with actual data from backend)
        val userProfile = profileDetails(
            id = 1,
            name = "Karen Joy C. Ferrer",
            email = "karenjoy@mail.com",
            profileImage = "https://example.com/profile.jpg",
            scholarship = "Full Scholarship",
            expertTeacher = "Mr. Smith",
            schedule = "Monday - Friday",
            hkDutyStatus = "Active",
            totalHoursToRender = 100,
            totalHoursRendered = 50,
            scholarshipType = "Academic",
            hkSf = "Pending"
        )

        // Set data in UI
        profileName.text = userProfile.name
        profileDetails.setText(
            "Scholarship: ${userProfile.scholarship}\n" +
                    "Expert Teacher: ${userProfile.expertTeacher}\n" +
                    "Schedule: ${userProfile.schedule}\n" +
                    "HK Duty Status: ${userProfile.hkDutyStatus}"
        )
        profileActivity.setText(
            "Total hours to be rendered: ${userProfile.totalHoursToRender}\n" +
                    "Total hours rendered: ${userProfile.totalHoursRendered}\n" +
                    "Type Scholarship: ${userProfile.scholarshipType}\n" +
                    "HK SF: ${userProfile.hkSf}"
        )

        // Logout button click listener
        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close current activity
        }

        // Fix window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profileActivity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
