package com.natifedanilharitonov.data.di

import com.natifedanilharitonov.data.network.anime_image_source.RandomAnimeImageSource
import com.natifedanilharitonov.data.network.anime_image_source.RandomAnimeImageSourceImpl
import com.natifedanilharitonov.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.data.network.firebase.FirebaseUserSourceImpl
import com.natifedanilharitonov.data.network.image_downloader.ImageDownloaderSource
import com.natifedanilharitonov.data.network.image_downloader.ImageDownloaderSourceImpl
import com.natifedanilharitonov.data.network.users.UsersSource
import com.natifedanilharitonov.data.network.users.UsersSourceImpl
import com.natifedanilharitonov.data.source.random_text.RandomTextSource
import com.natifedanilharitonov.data.source.random_text.RandomTextSourceImpl
import com.natifedanilharitonov.data.source.stats.RandomStatsSource
import com.natifedanilharitonov.data.source.stats.RandomStatsSourceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val sourceModule = module {
    factory<FirebaseUserSource> {
        FirebaseUserSourceImpl(get())
    }

    factory<RandomAnimeImageSource> {
        RandomAnimeImageSourceImpl(
            get(),
            androidApplication()
        )
    }

    factory<UsersSource> {
        UsersSourceImpl(get(), get())
    }

    factory<RandomTextSource> {
        RandomTextSourceImpl()
    }

    factory<RandomStatsSource> {
        RandomStatsSourceImpl()
    }

    factory<ImageDownloaderSource> {
        ImageDownloaderSourceImpl(androidApplication())
    }
}