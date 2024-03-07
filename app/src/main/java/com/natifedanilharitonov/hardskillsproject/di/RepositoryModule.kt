package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<ResourcesRepository> {
        ResourcesRepositoryImpl(get())
    }
}