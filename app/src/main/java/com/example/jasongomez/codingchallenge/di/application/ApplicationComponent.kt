package com.example.jasongomez.codingchallenge.di.application

import com.example.jasongomez.codingchallenge.di.activity.ActivityComponent
import com.example.jasongomez.codingchallenge.di.activity.ActivityModule
import com.example.jasongomez.codingchallenge.ui.viewmodels.MainViewModel
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

    fun inject(mainViewModel: MainViewModel)
}