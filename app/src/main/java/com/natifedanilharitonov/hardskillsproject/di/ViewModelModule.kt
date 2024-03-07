package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.login.EmailValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.PasswordValidationUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginReducer
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationReducer
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationViewModelImpl
import org.koin.dsl.module

val viewModelModule = module {
    factory {
        LoginViewModelImpl(
            reducer = LoginReducer(),
            useCases = setOf(
                get<EmailValidationUseCase>(),
                get<PasswordValidationUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        RegistrationViewModelImpl(
            reducer = RegistrationReducer(),
            useCases = setOf(),
            navigator = get()
        )
    }
}