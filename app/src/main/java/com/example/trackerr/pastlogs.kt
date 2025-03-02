package com.example.trackerr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class pastlogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pastlogs)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.nav_graph)

        // Link Bottom Navigation with Navigation Component
        bottomNavigationView.setupWithNavController(navController)

        val log1 = LogEntry(id = 1, message = "User logged in")
        val log2 = LogEntry(id = 2, message = "User updated profile")

        val logsList = mutableListOf(log1, log2)
    }
}
