package com.example.jasongomez.codingchallenge.data.Remote

import com.example.jasongomez.codingchallenge.data.Remote.models.WeatherApiResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("data/2.5/forecast")
    fun getWeatherForecast(@Query("id") cityId:String, @Query("APPID") apiKey:String): Deferred<WeatherApiResponse>
}