package com.example.jasongomez.codingchallenge.ui.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.jasongomez.codingchallenge.AppController
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather
import com.example.jasongomez.codingchallenge.data.RepositoryModule.RepositoryImpl
import com.example.jasongomez.codingchallenge.interfaces.Repository
import javax.inject.Inject

class MainViewModel(context: Application) : AndroidViewModel(context) {

    @Inject
    lateinit var repository: Repository

    init {
        (context as AppController).applicationComponent?.inject(this)
    }

    fun getWeatherForecast(): LiveData<List<Weather>> {
        repository.getWeatherForecast()
        return (repository as RepositoryImpl).weatherForecastLiveData
    }
}