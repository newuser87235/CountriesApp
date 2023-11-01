package com.example.myapplication.repositories

import com.example.myapplication.model.CountryAPI
import com.example.myapplication.model.RetrofitClient

class CountryRepository {

    private val api: CountryAPI = RetrofitClient.apiService

    suspend fun getCountries() = api.getCountries()
}
