package com.example.weather.ui.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemCityBinding
import com.example.weather.ui.weather.model.Cities

class CitiesAdapter(
    private val onCityClick: (Cities) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    private var cities: List<Cities> = emptyList()

    fun updateCities(newCities: List<Cities>) {
        cities = newCities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CitiesViewHolder(binding)
    }

    override fun getItemCount(): Int = cities.size

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    inner class CitiesViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: Cities) {
            with(binding) {
                cityName.text = city.city
                cityTemperature.text = "${city.grades}°C"
                root.setOnClickListener { onCityClick(city) }
            }
        }
    }
}