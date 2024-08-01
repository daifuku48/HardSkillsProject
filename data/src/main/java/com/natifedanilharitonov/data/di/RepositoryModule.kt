package com.natifedanilharitonov.data.di

import com.natifedanilharitonov.data.repository.firebase.FirebaseUserRepositoryImpl
import com.natifedanilharitonov.data.repository.mockText.MockTextRepositoryImpl
import com.natifedanilharitonov.data.repository.randomImages.RandomAnimeImageRepositoryImpl
import com.natifedanilharitonov.data.repository.stats.RandomStatsRepositoryImpl
import com.natifedanilharitonov.data.repository.users.UserRepositoryImpl
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule =
    module {
        factory<FirebaseUserRepository> {
            FirebaseUserRepositoryImpl(get())
        }

        factory<RandomAnimeImageRepository> {
            RandomAnimeImageRepositoryImpl(get())
        }

        factory<UsersRepository> {
            UserRepositoryImpl(get())
        }

        factory<MockTextRepository> {
            MockTextRepositoryImpl(get())
        }

        factory<RandomStatsRepository> {
            RandomStatsRepositoryImpl(get())
        }
    }
