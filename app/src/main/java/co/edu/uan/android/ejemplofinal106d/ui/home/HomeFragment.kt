package co.edu.uan.android.ejemplofinal106d.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.edu.uan.android.ejemplofinal106d.databinding.FragmentHomeBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        //Load image with Picasso
        Picasso
            .get()
            .load("https://i.imgur.com/DvpvklR.png")
            .rotate(45.0f)
            .into(binding.imageView)
        // Animate the image with YoYo
        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(5)
            .playOn(binding.imageView);
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}