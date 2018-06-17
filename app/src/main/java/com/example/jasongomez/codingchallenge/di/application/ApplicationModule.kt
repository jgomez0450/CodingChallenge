package com.example.jasongomez.codingchallenge.di.application

import android.content.Context
import com.example.jasongomez.codingchallenge.AppController
import com.example.jasongomez.codingchallenge.data.Remote.RemoteServiceHelper
import com.example.jasongomez.codingchallenge.data.RepositoryModule.RepositoryImpl
import com.example.jasongomez.codingchallenge.interfaces.Repository
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val application: AppController) {


    @Provides
    @ApplicationScope
    fun providesApplicationContext(): Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun providesRemoteServiceHelper(): RemoteServiceHelper {
        return RemoteServiceHelper()
    }

    @Provides
    @ApplicationScope
    fun providesRepositoryImpl(remoteServiceHelper: RemoteServiceHelper): Repository {
        return RepositoryImpl(remoteServiceHelper)
    }
}