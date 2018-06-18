package com.example.jasongomez.codingchallenge

import android.arch.lifecycle.Observer
import com.example.jasongomez.codingchallenge.data.Remote.RemoteServiceHelper
import com.example.jasongomez.codingchallenge.data.Remote.models.Weather
import com.example.jasongomez.codingchallenge.data.RepositoryModule.Repository
import com.example.jasongomez.codingchallenge.utils.Constants
import org.hamcrest.Matchers.*
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    lateinit var observer: Observer<List<List<Weather>>>

    @Mock
    lateinit var repository: Repository

    @Test
    fun givenBaseUrl_whenMethodIsInvoked_thenShouldReturnRetrofit() {
        val remoteServiceHelper = RemoteServiceHelper()
        val result = remoteServiceHelper.getRetrofit(Constants.WEATHER_API_BASE_URL)
        assertThat(result is Retrofit, `is`(true))
    }

}
