package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.repository.firebase.FirebaseUserRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.mock_text.MockTextRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.random_images.RandomAnimeImageRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.RecoursesInfoRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.ResourcesAuthRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.users.UserRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.domain.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomAnimeImageRepository
import com.natifedanilharitonov.hardskillsproject.domain.repository.RecoursesInfoRepository
import com.natifedanilharitonov.hardskillsproject.domain.repository.ResourcesAuthRepository
import com.natifedanilharitonov.hardskillsproject.domain.repository.UsersRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ResourcesAuthRepository> {
        ResourcesAuthRepositoryImpl(get())
    }

    factory<FirebaseUserRepository> {
        FirebaseUserRepositoryImpl(get())
    }

    factory<RecoursesInfoRepository> {
        RecoursesInfoRepositoryImpl(get())
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
}