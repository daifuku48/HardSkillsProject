package com.natifedanilharitonov.hardskillsproject.app

import android.app.Application
import com.google.firebase.FirebaseApp
import com.natifedanilharitonov.data.di.networkModule
import com.natifedanilharitonov.data.di.repositoryModule
import com.natifedanilharitonov.data.di.sourceModule
import com.natifedanilharitonov.domain.di.domainModule
import com.natifedanilharitonov.hardskillsproject.di.mapperModule
import com.natifedanilharitonov.hardskillsproject.di.navigationModule
import com.natifedanilharitonov.hardskillsproject.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                navigationModule,
                networkModule,
                domainModule,
                repositoryModule,
                viewModelModule,
                sourceModule,
                mapperModule,
            )
        }
    }
}
