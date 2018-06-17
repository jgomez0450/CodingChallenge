package com.example.jasongomez.codingchallenge.ui

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.jasongomez.codingchallenge.AppController
import com.example.jasongomez.codingchallenge.R
import com.example.jasongomez.codingchallenge.di.activity.ActivityModule
import com.example.jasongomez.codingchallenge.ui.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependencies()
    }

    private fun injectDependencies() {
        (application as AppController).createApplicationComponent()?.newFragmentComponent(ActivityModule(this))?.inject(this)
    }

    private fun setUpObservers() {
        mainViewModel.getWeatherForecast().observe(this, Observer {
            it?.let {

            }
        })
    }
}
