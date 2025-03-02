package com.example.trackerr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.trackerr.R.id.btnforgot

class forgotPass : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forgot_pass, container, false)

        // Correctly referencing the button ID
        val resetButton: TextView = view.findViewById(btnforgot)
        val forgotPasswordData = ForgotPassword(email = "user@mail.com")


        // Set click listener to navigate to NewPass fragment
        resetButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, forgotPass()) // Ensure the class name is correct
                .addToBackStack(null) // Allows back navigation
                .commit()
        }

        return view
    }
}
