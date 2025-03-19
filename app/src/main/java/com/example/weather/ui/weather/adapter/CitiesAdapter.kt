package com.example.weather.ui.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.ItemCityBinding
import com.example.weather.ui.weather.model.City

class CitiesAdapter(
    private val onCityClick: (City) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    private var cities: List<City> = emptyList()

    fun updateCities(newCities: List<City>) {
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
        fun bind(city: City) {
            with(binding) {
                cityName.text = city.city
                cityTemperature.text = "${city.grades} °C"
                root.setOnClickListener { onCityClick(city) }
            }
        }
    }
}