package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapters.CountryAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.CountryViewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val viewModel: CountryViewModel by viewModels()

    private var countriesAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Set up RecyclerView
        binding?.rvCountries?.apply {
            adapter = countriesAdapter
            layoutManager = LinearLayoutManager(context)
        }

        // Observe ViewModel's countries LiveData
        viewModel.countries.observe(this, Observer { countries ->
            // Update RecyclerView's adapter
            countriesAdapter.countryList = countries
            countriesAdapter.notifyDataSetChanged()
        })
    }
}