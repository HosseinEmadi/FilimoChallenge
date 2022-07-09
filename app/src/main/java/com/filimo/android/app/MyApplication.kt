package com.filimo.android.app

import android.app.Application
import com.filimo.android.app.searchMovies.di.searchMoviesModule
import com.filimo.android.di.appModule
import com.filimo.android.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                appModule,
                networkModule,
                searchMoviesModule
            ))
            androidContext(applicationContext)
        }
    }
}