package co.edu.uan.android.ejemplofinal106d.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.uan.android.ejemplofinal106d.databinding.FragmentDashboardBinding
import com.squareup.picasso.Picasso

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel.catUrl.observe(viewLifecycleOwner) {
            Picasso.get()
                .load(it)
                .into(binding.imageDashboard)
        }

        binding.btnRefreshPhoto.setOnClickListener {
            // llamar la logica que descarga una foto usando el API
            dashboardViewModel.refreshPhoto()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}