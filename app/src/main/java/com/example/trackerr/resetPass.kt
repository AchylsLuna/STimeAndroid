import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.trackerr.R

class resetPass : Fragment(R.layout.fragment_reset_pass) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resetButton = view.findViewById<Button>(R.id.resetPasswordButton)
        resetButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SuccessPageFragment()) // Navigate to successPage
                addToBackStack(null) // Enables back navigation
            }
        }
    }
}
