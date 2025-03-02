package com.example.trackerr

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trackerr.network.APIService
import com.example.trackerr.network.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class logs : Activity() {
private val apiService = RetrofitClient.create(APIService::class.java)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_logs)

    val dateInput = findViewById<EditText>(R.id.dateInput)
    val timeInInput = findViewById<EditText>(R.id.timeIn)
    val timeOutInput = findViewById<EditText>(R.id.timeOut)
    val submitButton = findViewById<Button>(R.id.LogsSubmit)

    submitButton.setOnClickListener {
        val userId = 123 // Replace with actual user ID
        val date = dateInput.text.toString()
        val timeIn = timeInInput.text.toString()
        val timeOut = timeOutInput.text.toString()

        if (date.isNotEmpty() && timeIn.isNotEmpty() && timeOut.isNotEmpty()) {
            submitTime(userId, date, timeIn, timeOut)
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }
}

private fun submitTime(userId: Int, date: String, timeIn: String, timeOut: String) {
    apiService.submitTime(userId, date, timeIn, timeOut).enqueue(object : Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.isSuccessful) {
                Toast.makeText(this@logs, "Log submitted successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@logs, "Error: ${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            Toast.makeText(this@logs, "Failed: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}
}
