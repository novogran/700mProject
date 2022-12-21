package com.example.a700mproject.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a700mproject.databinding.FragmentBonusesBinding

class BonusesFragment : Fragment() {

    private var _binding: FragmentBonusesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bonusesViewModel =
            ViewModelProvider(this).get(BonusesViewModel::class.java)

        _binding = FragmentBonusesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        bonusesViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}