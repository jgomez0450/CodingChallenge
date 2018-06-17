package com.example.jasongomez.codingchallenge.ui

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.example.jasongomez.codingchallenge.AppController
import com.example.jasongomez.codingchallenge.R
import com.example.jasongomez.codingchallenge.adapters.WeatherAdapter
import com.example.jasongomez.codingchallenge.databinding.ActivityMainBinding
import com.example.jasongomez.codingchallenge.di.activity.ActivityModule
import com.example.jasongomez.codingchallenge.ui.viewmodels.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        injectDependencies()
        setUpObservers()
    }

    private fun injectDependencies() {
        (application as AppController).createApplicationComponent()?.newFragmentComponent(ActivityModule(this))?.inject(this)
    }

    private fun setUpObservers() {
        mainViewModel.getWeatherForecast().observe(this, Observer {
            it?.let {
                binding!!.recyclerView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = WeatherAdapter(it)
                    itemAnimator = DefaultItemAnimator()
                }
            }
        })
    }
}
