package com.natifedanilharitonov.data.di

import com.natifedanilharitonov.data.network.animeImageSource.RandomAnimeImageSource
import com.natifedanilharitonov.data.network.animeImageSource.RandomAnimeImageSourceImpl
import com.natifedanilharitonov.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.data.network.firebase.FirebaseUserSourceImpl
import com.natifedanilharitonov.data.network.users.UsersSource
import com.natifedanilharitonov.data.network.users.UsersSourceImpl
import com.natifedanilharitonov.data.source.randomText.RandomTextSource
import com.natifedanilharitonov.data.source.randomText.RandomTextSourceImpl
import com.natifedanilharitonov.data.source.stats.RandomStatsSource
import com.natifedanilharitonov.data.source.stats.RandomStatsSourceImpl
import org.koin.dsl.module

val sourceModule =
    module {
        factory<FirebaseUserSource> {
            FirebaseUserSourceImpl(get())
        }

        factory<RandomAnimeImageSource> {
            RandomAnimeImageSourceImpl(
                get(),
            )
        }

        factory<UsersSource> {
            UsersSourceImpl(get())
        }

        factory<RandomTextSource> {
            RandomTextSourceImpl()
        }

        factory<RandomStatsSource> {
            RandomStatsSourceImpl()
        }
    }
