package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.domain.use_cases.info.GetUserInfoUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.login.LoginUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.main.GetMainTextUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.main_activity.GetStartDestinationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.main_first.GetTextFirstMainUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.main_second.GetTextSecondMainUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.random_anime_image.GetAnimeImageUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.registration.RegisterUserUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings.SignOutUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings_first.GetTextSettingsFirstUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings_second.GetTextSettingsSecondUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.user_list.GetUsersUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityReducer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginReducer
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainReducer
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main_first.MainFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.main_first.MainFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main_second.MainSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.main_second.MainSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageReducer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.RandomAnimeImageViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationReducer
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settings_first.SettingsFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settings_first.SettingsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settings_second.SettingsSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settings_second.SettingsSecondViewModelImpl
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
        MainViewModelImpl(
            reducer = MainReducer(),
            useCases = setOf(
                get<GetMainTextUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainFirstViewModelImpl(
            reducer = MainFirstReducer(),
            useCases = setOf(
                get<GetTextFirstMainUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainSecondViewModelImpl(
            reducer = MainSecondReducer(),
            useCases = setOf(
                get<GetTextSecondMainUseCase>()
            ),
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
                get<GetAnimeImageUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        UserListViewModelImpl(
            reducer = UserListReducer(),
            useCases = setOf(
                get<GetUsersUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        SettingsViewModelImpl(
            reducer = SettingsReducer(),
            useCases = setOf(
                get<SignOutUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        SettingsFirstViewModelImpl(
            reducer = SettingsFirstReducer(),
            useCases = setOf(
                get<GetTextSettingsFirstUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        SettingsSecondViewModelImpl(
            reducer = SettingsSecondReducer(),
            useCases = setOf(
                get<GetTextSettingsSecondUseCase>()
            ),
            navigator = get()
        )
    }
}