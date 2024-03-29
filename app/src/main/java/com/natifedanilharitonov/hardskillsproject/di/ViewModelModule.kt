package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.domain.use_cases.info.GetUserInfoUseCase
import com.natifedanilharitonov.domain.use_cases.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.domain.use_cases.login.LoginUserUseCase
import com.natifedanilharitonov.domain.use_cases.main.GetMainTextUseCase
import com.natifedanilharitonov.domain.use_cases.main_activity.GetStartDestinationUseCase
import com.natifedanilharitonov.domain.use_cases.main_first.GetTextFirstMainUseCase
import com.natifedanilharitonov.domain.use_cases.main_second.GetTextSecondMainUseCase
import com.natifedanilharitonov.domain.use_cases.random_anime_image.GetAnimeImageUseCase
import com.natifedanilharitonov.domain.use_cases.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.domain.use_cases.registration.RegisterUserUseCase
import com.natifedanilharitonov.domain.use_cases.settings.SignOutUseCase
import com.natifedanilharitonov.domain.use_cases.settings_first.GetTextSettingsFirstUseCase
import com.natifedanilharitonov.domain.use_cases.settings_second.GetTextSettingsSecondUseCase
import com.natifedanilharitonov.domain.use_cases.statistics.GetModelStatsStatisticsUseCase
import com.natifedanilharitonov.domain.use_cases.statistics_first.GetModelDataStatFirstUseCase
import com.natifedanilharitonov.domain.use_cases.statistics_second.GetModelToSecondChartUseCase
import com.natifedanilharitonov.domain.use_cases.user_list.GetUsersUseCase
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
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.StatisticsFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.StatisticsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.StatisticsSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.StatisticsSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListReducer
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListViewModelImpl
import org.koin.dsl.module

val viewModelModule = module {
    factory {
        LoginViewModelImpl(
            reducer = LoginReducer(get(), get()),
            useCases = setOf(
                get<EmailPasswordLoginValidationUseCase>(),
                get<LoginUserUseCase>(),
            ),
            navigator = get()
        )
    }

    factory {
        RegistrationViewModelImpl(
            reducer = RegistrationReducer(get(), get()),
            useCases = setOf(
                get<EmailPasswordValidationRegistrationUseCase>(),
                get<RegisterUserUseCase>(),
            ),
            navigator = get()
        )
    }

    factory {
        MainActivityViewModelImpl(
            reducer = MainActivityReducer(get()),
            useCases = setOf(
                get<GetStartDestinationUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainViewModelImpl(
            reducer = MainReducer(get()),
            useCases = setOf(
                get<GetMainTextUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainFirstViewModelImpl(
            reducer = MainFirstReducer(get()),
            useCases = setOf(
                get<GetTextFirstMainUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        MainSecondViewModelImpl(
            reducer = MainSecondReducer(get()),
            useCases = setOf(
                get<GetTextSecondMainUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        InfoViewModelImpl(
            reducer = InfoReducer(get()),
            useCases = setOf(
                get<GetUserInfoUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        RandomAnimeImageViewModelImpl(
            reducer = RandomAnimeImageReducer(get()),
            useCases = setOf(
                get<GetAnimeImageUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        UserListViewModelImpl(
            reducer = UserListReducer(get()),
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
            reducer = SettingsFirstReducer(get()),
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

    factory {
        StatisticsViewModelImpl(
            reducer = StatisticsReducer(get()),
            useCases = setOf(
                get<GetModelStatsStatisticsUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        StatisticsFirstViewModelImpl(
            reducer = StatisticsFirstReducer(get()),
            useCases = setOf(
                get<GetModelDataStatFirstUseCase>()
            ),
            navigator = get()
        )
    }

    factory {
        StatisticsSecondViewModelImpl(
            reducer = StatisticsSecondReducer(get()),
            useCases = setOf(
                GetModelToSecondChartUseCase(get())
            ),
            navigator = get()
        )
    }
}