package com.example.trackerr

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.trackerr.R
import com.example.trackerr.fragment.SuccessPageFragment // Ensure the correct package import
import fragment.SuccessPageFragment

class ResetPassFragment : Fragment(R.layout.fragment_reset_pass) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resetButton: Button = view.findViewById(R.id.resetPasswordButton)
        resetButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SuccessPageFragment()) // Navigate to SuccessPage
                addToBackStack(null) // Enables back navigation
            }
        }
    }

    private fun replace(fragmentContainer: Int, successPageFragment: SuccessPageFragment) {
        TODO("Not yet implemented")
    }
}
