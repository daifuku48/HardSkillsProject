package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.info.GetUserInfoUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.login.LoginUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.main_activity.GetStartDestinationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.random_anime_image.GetAnimeImageUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.registration.RegisterUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.user_list.GetUsersUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityReducer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginReducer
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainReducer
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainViewModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageReducer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationReducer
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListReducer
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListViewModelImpl
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
        MainActivityViewModelImpl(
            reducer = MainActivityReducer(),
            useCases = setOf(
                get<GetStartDestinationUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainViewModel(
            reducer = MainReducer(),
            useCases = setOf(),
            navigator = get()
        )
    }

    factory {
        InfoViewModelImpl(
            reducer = InfoReducer(),
            useCases = setOf(
                get<GetUserInfoUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        RandomAnimeImageViewModelImpl(
            reducer = RandomAnimeImageReducer(),
            useCases = setOf(
                GetAnimeImageUseCase(get())
            ),
            navigator = get()
        )
    }

    factory {
        UserListViewModelImpl(
            reducer = UserListReducer(),
            useCases = setOf(
                GetUsersUseCase(get())
            ),
            navigator = get()
        )
    }
}