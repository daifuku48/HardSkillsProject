package com.natifedanilharitonov.hardskillsproject.di

import org.koin.dsl.module

val navigationModule = module {
    single<Navigator> {
        AppNavigator()
    }
}
