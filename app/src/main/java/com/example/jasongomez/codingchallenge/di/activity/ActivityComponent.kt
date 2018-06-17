package com.example.jasongomez.codingchallenge.di.activity

import com.example.jasongomez.codingchallenge.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}