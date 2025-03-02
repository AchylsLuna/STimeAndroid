import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.trackerr.R

class success_page : Fragment(R.layout.success_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val goToLoginButton = view.findViewById<Button>(R.id.continueButton) // Ensure R.id.Mai is the correct ID for your button

        goToLoginButton.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            requireActivity().finish() // Close the current activity hosting the fragment
        }
    }
}
