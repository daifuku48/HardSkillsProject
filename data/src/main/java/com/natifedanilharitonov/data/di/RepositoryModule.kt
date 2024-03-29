package com.natifedanilharitonov.data.di

import com.natifedanilharitonov.data.repository.firebase.FirebaseUserRepositoryImpl
import com.natifedanilharitonov.data.repository.mock_text.MockTextRepositoryImpl
import com.natifedanilharitonov.data.repository.random_images.RandomAnimeImageRepositoryImpl
import com.natifedanilharitonov.data.repository.stats.RandomStatsRepositoryImpl
import com.natifedanilharitonov.data.repository.users.UserRepositoryImpl
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository
import com.natifedanilharitonov.domain.repository.MockTextRepository
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository
import com.natifedanilharitonov.domain.repository.RandomStatsRepository
import com.natifedanilharitonov.domain.repository.UsersRepository
import org.koin.dsl.module


val repositoryModule = module {
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