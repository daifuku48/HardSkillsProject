package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.RandomAnimeImageSource
import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.RandomAnimeImageSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.hardskillsproject.data.network.firebase.FirebaseUserSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesAuthSource
import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesAuthSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesInfoSource
import com.natifedanilharitonov.hardskillsproject.data.source.ResourcesInfoSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sourceModule = module {
    factory<ResourcesAuthSource> {
        ResourcesAuthSourceImpl(androidApplication().applicationContext)
    }

    factory<ResourcesInfoSource> {
        ResourcesInfoSourceImpl(androidApplication().applicationContext)
    }

    factory<FirebaseUserSource> {
        FirebaseUserSourceImpl(get())
    }

    factory<RandomAnimeImageSource> {
        RandomAnimeImageSourceImpl(get())
    }
}