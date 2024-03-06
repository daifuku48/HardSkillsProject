package com.natifedanilharitonov.hardskillsproject.app

import android.app.Application
import com.natifedanilharitonov.hardskillsproject.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                navigationModule
            )
        }
    }
}