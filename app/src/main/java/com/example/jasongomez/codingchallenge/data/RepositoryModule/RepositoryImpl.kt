package com.example.jasongomez.codingchallenge.data.RepositoryModule

import android.arch.lifecycle.MutableLiveData
import com.example.jasongomez.codingchallenge.data.Remote.RemoteServiceHelper
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather
import com.example.jasongomez.codingchallenge.interfaces.Repository
import kotlinx.coroutines.experimental.CoroutineExceptionHandler
import kotlinx.coroutines.experimental.launch
import retrofit2.HttpException

class RepositoryImpl(private val remoteServiceHelper: RemoteServiceHelper) : Repository {

    val weatherForecastLiveData: MutableLiveData<MutableList<Weather>> = MutableLiveData()

    override fun getWeatherForecast() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            if (throwable is HttpException) {
                //TODO implement exception handling
            } else {
                //TODO implement exception handling
            }
        }

        launch(exceptionHandler) {
            val weatherApiResponse = remoteServiceHelper.getWeatherForecast().await()
            weatherApiResponse.city?.list?.weather?.let {
                weatherForecastLiveData.postValue(it)
            }
        }
    }


}