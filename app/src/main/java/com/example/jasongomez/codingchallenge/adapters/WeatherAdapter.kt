package com.example.jasongomez.codingchallenge.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.jasongomez.codingchallenge.R
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather
import com.example.jasongomez.codingchallenge.databinding.RecyclerViewItemBinding

class WeatherAdapter(private val weatherList: List<List<Weather>>, private val context: Context) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        val itemBinding = DataBindingUtil.inflate<RecyclerViewItemBinding>(LayoutInflater.from(parent.context), R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val temp = weatherList[position][0]
        val dateAndTime = temp.date?.split(" ")
        holder.binding.textViewMain.text = context.resources.getString(R.string.all_weatherMain).format(temp.main, dateAndTime?.get(0), dateAndTime?.get(1))
        holder.binding.textViewDescription.text = temp.description
        Glide.with(context).load("http://openweathermap.org/img/w/${temp.icon}.png").into(holder.binding.imageViewIcon)
    }

    class ViewHolder(var binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)
}