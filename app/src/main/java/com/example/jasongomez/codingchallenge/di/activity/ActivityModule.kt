package com.example.jasongomez.codingchallenge.di.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.example.jasongomez.codingchallenge.ui.viewmodels.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun providesMainViewModel(): MainViewModel {
        return ViewModelProviders.of(activity).get(MainViewModel::class.java)
    }
}