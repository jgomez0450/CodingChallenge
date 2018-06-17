package com.example.jasongomez.codingchallenge.interfaces

import com.example.jasongomez.codingchallenge.data.Remote.models.WeatherApiResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("forecast")
    fun getWeatherForecast(@Query("id") cityId:String, @Query("APPID") apiKey:String): Deferred<WeatherApiResponse>
}