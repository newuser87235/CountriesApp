package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Country
import com.example.myapplication.repositories.CountryRepository
import kotlinx.coroutines.launch

class CountryViewModel(application: Application,) : AndroidViewModel(application) {
    private val repository = CountryRepository()

    val countries: LiveData<List<Country>> get() = _countries
    private val _countries = MutableLiveData<List<Country>>()

    init {
        fetchCountries()
    }

    private fun fetchCountries() {
        viewModelScope.launch{
            try {
                _countries.value = repository.getCountries()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}