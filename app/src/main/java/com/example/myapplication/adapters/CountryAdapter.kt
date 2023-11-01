package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCountryRvBinding

import com.example.myapplication.model.Country


class CountryAdapter(var countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    inner class CountryViewHolder(val itemBinding: ItemCountryRvBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(country: Country) {
            itemBinding.tvName.text = country.name
            itemBinding.tvCapital.text = country.capital
            itemBinding.tvRegion.text = country.region
            itemBinding.tvCode.text = country.code
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList[position])
    }
}
