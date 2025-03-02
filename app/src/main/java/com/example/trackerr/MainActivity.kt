package com.example.trackerr

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class MainActivity : Activity() {
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameInput = findViewById<EditText>(R.id.username)
        val passwordInput = findViewById<EditText>(R.id.password)
        val btnLogin = findViewById<Button>(R.id.signInbtn)

        btnLogin.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginUser(username, password)
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(username: String, password: String) {
        val url = "http://192.168.1.6/student/login.php"

        val formBody = FormBody.Builder()
            .add("username", username)
            .add("password", password)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(formBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(applicationContext, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let { responseBody ->
                    val jsonResponse = JSONObject(responseBody)
                    val success = jsonResponse.getBoolean("success")

                    runOnUiThread {
                        if (success) {
                            // Save username in SharedPreferences
                            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                            sharedPreferences.edit().putString("USERNAME", username).apply()

                            // Navigate to profile activity
                            val intent = Intent(applicationContext, profile::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val message = jsonResponse.getString("message")
                            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        })
    }
}


