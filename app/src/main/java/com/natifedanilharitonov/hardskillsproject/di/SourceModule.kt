package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.RandomAnimeImageSource
import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.RandomAnimeImageSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.hardskillsproject.data.network.firebase.FirebaseUserSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.source.random_text.RandomTextSource
import com.natifedanilharitonov.hardskillsproject.data.source.random_text.RandomTextSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.network.users.UsersSource
import com.natifedanilharitonov.hardskillsproject.data.network.users.UsersSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.source.auth.ResourcesAuthSource
import com.natifedanilharitonov.hardskillsproject.data.source.auth.ResourcesAuthSourceImpl
import com.natifedanilharitonov.hardskillsproject.data.source.info.ResourcesInfoSource
import com.natifedanilharitonov.hardskillsproject.data.source.info.ResourcesInfoSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sourceModule = module {
    factory<ResourcesAuthSource> {
        ResourcesAuthSourceImpl(androidApplication())
    }

    factory<ResourcesInfoSource> {
        ResourcesInfoSourceImpl(androidApplication())
    }

    factory<FirebaseUserSource> {
        FirebaseUserSourceImpl(get())
    }

    factory<RandomAnimeImageSource> {
        RandomAnimeImageSourceImpl(get(), androidApplication())
    }

    factory<UsersSource> {
        UsersSourceImpl(get())
    }

    factory<RandomTextSource> {
        RandomTextSourceImpl()
    }
}