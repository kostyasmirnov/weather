package com.example.weather.ui.weather

import android.icu.text.DateFormat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.ui.weather.model.Cities
import java.time.LocalDate
import java.util.Date

class WeatherViewModel : ViewModel() {

    private val _cities = MutableLiveData<List<Cities>>()
    val cities: LiveData<List<Cities>> = _cities

    init {
        loadCities()
    }

    private fun loadCities() {
        val citiesList = listOf(
            Cities("Москва", 20.0, ""),
            Cities("Санкт-Петербург", 18.5, ""),
            Cities("Новосибирск", 22.3, ""),
            Cities("Екатеринбург", 19.8, ""),
            Cities("Казань", 21.5, "")
        )
        _cities.value = citiesList
    }
}