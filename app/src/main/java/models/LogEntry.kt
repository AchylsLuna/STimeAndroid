package com.example.trackerr

import java.time.LocalDateTime

data class LogEntry(
    val id: Int, // Unique identifier for the log entry
    val message: String, // Log message
    val timestamp: LocalDateTime = LocalDateTime.now() // Timestamp of the log
)
    val log1 = LogEntry(id = 1, message = "User logged in")
    val log2 = LogEntry(id = 2, message = "User updated profile")

    val logsList = mutableListOf(log1, log2)

