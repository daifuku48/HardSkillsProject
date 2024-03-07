package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.login.EmailValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.PasswordValidationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        EmailValidationUseCase(get())
    }

    factory {
        PasswordValidationUseCase(get())
    }
}