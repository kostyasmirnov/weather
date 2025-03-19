package com.example.weather.ui.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.ui.weather.model.City

class WeatherViewModel : ViewModel() {

    private val _city = MutableLiveData<List<City>>()
    val city: LiveData<List<City>> = _city

    init {
        loadCities()
    }

    private fun loadCities() {
        val cityLists = listOf(
            City("Москва", 20.0, ""),
            City("Санкт-Петербург", 18.5, ""),
            City("Новосибирск", 22.3, ""),
            City("Екатеринбург", 19.8, ""),
            City("Казань", 21.5, "")
        )
        _city.value = cityLists
    }
}