package com.example.weather.ui.weather

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weather.R

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = getApplication<Application>().getString(R.string.title_list_of_cities)
    }
    val text: LiveData<String> = _text
}