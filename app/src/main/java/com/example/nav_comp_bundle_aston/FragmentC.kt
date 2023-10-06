package com.example.nav_comp_bundle_aston

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nav_comp_bundle_aston.databinding.FragmentCBinding

private const val ARGS_NAME = "args"

class FragmentC : Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.helloFragmentCTv.text = requireArguments().getString(ARGS_NAME)

        binding.goToFragmentD.setOnClickListener { findNavController().navigate(R.id.action_fragmentC_to_fragmentD) }
        binding.goToBack.setOnClickListener { findNavController().popBackStack(R.id.fragmentB, false) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}