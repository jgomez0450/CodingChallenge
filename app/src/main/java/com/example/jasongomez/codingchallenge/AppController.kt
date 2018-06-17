package com.example.jasongomez.codingchallenge

import android.app.Application
import android.content.Context
import com.example.jasongomez.codingchallenge.di.application.ApplicationComponent
import com.example.jasongomez.codingchallenge.di.application.ApplicationModule
import com.example.jasongomez.codingchallenge.di.application.DaggerApplicationComponent
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher

class AppController : Application() {

    //TODO check if this is even necessary
    companion object {
        fun getRefWatcher(context: Context): RefWatcher? {
            val application = context.applicationContext as AppController
            return application.refWatcher
        }
    }

    var applicationComponent: ApplicationComponent? = null
    var refWatcher: RefWatcher? = null

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        if (BuildConfig.DEBUG) {
            refWatcher = LeakCanary.install(this)
        }
    }

    fun clearApplicationComponent() {
        applicationComponent = null
    }

    fun createApplicationComponent(): ApplicationComponent? {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this))
                .build()
        return applicationComponent
    }

}