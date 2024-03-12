package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.LoginUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.main_activity.GetStartDestinationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.RegisterUserUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityReducer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModel
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
                get<EmailPasswordLoginValidationUseCase>(),
                get<LoginUserUseCase>(),
            ),
            navigator = get()
        )
    }

    factory {
        RegistrationViewModelImpl(
            reducer = RegistrationReducer(),
            useCases = setOf(
                get<EmailPasswordValidationRegistrationUseCase>(),
                get<RegisterUserUseCase>(),
            ),
            navigator = get()
        )
    }

    factory {
        MainActivityViewModel(
            reducer = MainActivityReducer(),
            useCases = setOf(
                get<GetStartDestinationUseCase>()
            ),
            navigator = get()
        )
    }
}