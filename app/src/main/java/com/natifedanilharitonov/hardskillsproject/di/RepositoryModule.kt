package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.repository.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.FirebaseUserRepositoryImpl
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<ResourcesRepository> {
        ResourcesRepositoryImpl(get())
    }

    factory<FirebaseUserRepository> {
        FirebaseUserRepositoryImpl(get())
    }
}