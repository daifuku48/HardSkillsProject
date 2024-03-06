package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginReducer
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelBase
import org.koin.dsl.module

val viewModelModule = module {
    factory {
        LoginViewModelBase(
            reducer = LoginReducer(),
            useCases = setOf(),
            navigator = get()
        )
    }


}