package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.LoginUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.RegisterUserUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        EmailPasswordLoginValidationUseCase(get())
    }

    factory {
        EmailPasswordValidationRegistrationUseCase(get())
    }

    factory {
        LoginUserUseCase(get())
    }

    factory {
        RegisterUserUseCase(get())
    }
}
