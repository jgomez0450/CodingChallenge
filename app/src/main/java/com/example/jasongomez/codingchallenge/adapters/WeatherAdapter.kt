package com.example.jasongomez.codingchallenge.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jasongomez.codingchallenge.R
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather
import com.example.jasongomez.codingchallenge.databinding.RecyclerViewItemBinding

class WeatherAdapter(private val weatherList: List<Weather>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val itemBinding = DataBindingUtil.inflate<RecyclerViewItemBinding>(LayoutInflater.from(parent.context), R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewMain.text = weatherList[position].main
        holder.binding.textViewDescription.text = weatherList[position].description
        holder.binding.textViewIcon.text = weatherList[position].icon
    }

    class ViewHolder(var binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)
}