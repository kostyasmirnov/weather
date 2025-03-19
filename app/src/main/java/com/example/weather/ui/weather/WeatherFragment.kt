package com.example.weather.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.databinding.FragmentListOfCitiesBinding
import com.example.weather.ui.weather.adapter.CitiesAdapter
import com.example.weather.ui.weather.model.City

class WeatherFragment : Fragment() {

    private var _binding: FragmentListOfCitiesBinding? = null
    private val binding get() = _binding!!
    private lateinit var citiesAdapter: CitiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        _binding = FragmentListOfCitiesBinding.inflate(inflater, container, false)

        setupRecyclerView()
        
        weatherViewModel.city.observe(viewLifecycleOwner) { cities ->
            citiesAdapter.updateCities(cities)
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        citiesAdapter = CitiesAdapter { city ->
            navigateToCityDetails(city)
        }
        binding.recyclerWeather.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
        }
    }

    private fun navigateToCityDetails(city: City) {
        val action = WeatherFragmentDirections.actionCitiesListToCityDetails(
            cityName = city.city,
            temperature = city.grades.toFloat(),
        )
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}