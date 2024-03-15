package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.repository.firebase.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.firebase.FirebaseUserRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.random_images.RandomAnimeImageRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.random_images.RandomAnimeImageRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.RecoursesInfoRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.RecoursesInfoRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.ResourcesAuthRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.ResourcesAuthRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.users.UserRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.users.UsersRepository
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
}