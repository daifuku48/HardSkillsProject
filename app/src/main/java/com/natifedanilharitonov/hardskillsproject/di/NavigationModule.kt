package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.base.navigation.AppNavigator
import com.natifedanilharitonov.hardskillsproject.base.navigation.Navigator
import org.koin.dsl.module

val navigationModule =
    module {
        single<Navigator> {
            AppNavigator()
        }
    }
