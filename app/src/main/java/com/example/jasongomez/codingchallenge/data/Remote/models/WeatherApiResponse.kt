package com.example.jasongomez.codingchallenge.data.Remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherApiResponse {

    @SerializedName("city")
    @Expose
    var city: City? = null

}