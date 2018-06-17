package com.example.jasongomez.codingchallenge.data.Remote

import com.example.jasongomez.codingchallenge.data.Remote.models.WeatherApiResponse
import com.example.jasongomez.codingchallenge.interfaces.RemoteService
import com.example.jasongomez.codingchallenge.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteServiceHelper {

    fun getWeatherForecast(): Deferred<WeatherApiResponse> {
        val retrofit = getRetrofit(Constants.WEATHER_API_BASE_URL)
        val service = retrofit.create(RemoteService::class.java)
        return service.getWeatherForecast("5210847", "b82b90e31b3b9b2723540c4b31afb584")
    }

    private fun getRetrofit(baseUrl: String): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
                            .addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
    }
}