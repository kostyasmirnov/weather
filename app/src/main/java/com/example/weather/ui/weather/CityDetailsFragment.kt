package com.example.weather.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.weather.databinding.FragmentCityDetailsBinding

class CityDetailsFragment : Fragment() {

    private var _binding: FragmentCityDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: CityDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCityDetailsBinding.inflate(inflater, container, false)
        
        setupViews()
        initializeClickListeners()
        
        return binding.root
    }

    private fun setupViews() {
        with(binding) {
            cityName.text = args.cityName
            cityTemperature.text = "${args.temperature}"
        }
    }

    private fun initializeClickListeners() {
        binding.imageView.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 