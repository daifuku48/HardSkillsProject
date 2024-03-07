package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesSource
import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sourceModule = module {
    factory<ResourcesSource> {
        ResourcesSourceImpl(androidApplication().applicationContext)
    }
}