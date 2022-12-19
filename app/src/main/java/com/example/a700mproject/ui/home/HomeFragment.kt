package com.example.a700mproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a700mproject.HomeSpinnerFragment
import com.example.a700mproject.R
import com.example.a700mproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeSpinnerFragment {

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

        val textView: TextView = binding.homeFragmentTitle

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val directionSpinner: Spinner = binding.directionSpinner
        val pickUpSpotSpinner: Spinner = binding.pickupSpotSpinner

        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.direction_array,
                R.layout.home_fragment_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(R.layout.home_fragment_spinner_dropdown_item)
                directionSpinner.adapter = adapter
            }
        }

        return root
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}