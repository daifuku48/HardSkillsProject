package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.domain.features.info.GetUserInfoUseCase
import com.natifedanilharitonov.domain.features.info_first.GetTextFirstInfoUseCase
import com.natifedanilharitonov.domain.features.info_second.GetTextSecondInfoUseCase
import com.natifedanilharitonov.domain.features.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.domain.features.login.LoginUserUseCase
import com.natifedanilharitonov.domain.features.main.GetMainTextUseCase
import com.natifedanilharitonov.domain.features.main_activity.GetStartDestinationUseCase
import com.natifedanilharitonov.domain.features.main_first.GetTextFirstMainUseCase
import com.natifedanilharitonov.domain.features.main_second.GetTextSecondMainUseCase
import com.natifedanilharitonov.domain.features.random_anime_image.GetAnimeImageUseCase
import com.natifedanilharitonov.domain.features.random_anime_image_first.GetAnimeImageFirstUseCase
import com.natifedanilharitonov.domain.features.random_anime_image_second.GetAnimeImageSecondUseCase
import com.natifedanilharitonov.domain.features.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.domain.features.registration.RegisterUserUseCase
import com.natifedanilharitonov.domain.features.settings.SignOutUseCase
import com.natifedanilharitonov.domain.features.settings_first.GetTextSettingsFirstUseCase
import com.natifedanilharitonov.domain.features.settings_second.GetTextSettingsSecondUseCase
import com.natifedanilharitonov.domain.features.statistics.GetModelStatsStatisticsUseCase
import com.natifedanilharitonov.domain.features.statistics_first.GetModelDataStatFirstUseCase
import com.natifedanilharitonov.domain.features.statistics_second.GetModelToSecondChartUseCase
import com.natifedanilharitonov.domain.features.user_list.AddUsersUseCase
import com.natifedanilharitonov.domain.features.user_list.GetUsersUseCase
import com.natifedanilharitonov.domain.features.user_random_first.GetRandomUserFirstUseCase
import com.natifedanilharitonov.domain.features.user_random_second.GetRandomUserSecondUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityReducer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info_first.InfoFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info_first.InfoFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info_second.InfoSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info_second.InfoSecondViewModelImpl
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
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_first.RandomAnimeImageFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_first.RandomAnimeImageFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_second.RandomAnimeImageSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_second.RandomAnimeImageSecondViewModelImpl
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
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.UserRandomFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.UserRandomFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_second.UserRandomSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_second.UserRandomSecondViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModelImpl(
            reducer = LoginReducer(get(), get()),
            useCases = setOf(
                get<EmailPasswordLoginValidationUseCase>(),
                get<LoginUserUseCase>(),
            ),
            navigator = get()
        )
    }

    viewModel {
        RegistrationViewModelImpl(
            reducer = RegistrationReducer(get(), get()),
            useCases = setOf(
                get<EmailPasswordValidationRegistrationUseCase>(),
                get<RegisterUserUseCase>(),
            ),
            navigator = get()
        )
    }

    viewModel {
        MainActivityViewModelImpl(
            reducer = MainActivityReducer(get()),
            useCases = setOf(
                get<GetStartDestinationUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        MainViewModelImpl(
            reducer = MainReducer(get()),
            useCases = setOf(
                get<GetMainTextUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        MainFirstViewModelImpl(
            reducer = MainFirstReducer(get()),
            useCases = setOf(
                get<GetTextFirstMainUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        MainSecondViewModelImpl(
            reducer = MainSecondReducer(get()),
            useCases = setOf(
                get<GetTextSecondMainUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        InfoViewModelImpl(
            reducer = InfoReducer(get()),
            useCases = setOf(
                get<GetUserInfoUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        InfoFirstViewModelImpl(
            reducer = InfoFirstReducer(get()),
            useCases = setOf(
                get<GetTextFirstInfoUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        InfoSecondViewModelImpl(
            reducer = InfoSecondReducer(get()),
            useCases = setOf(
                get<GetTextSecondInfoUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        RandomAnimeImageViewModelImpl(
            reducer = RandomAnimeImageReducer(get()),
            useCases = setOf(
                get<GetAnimeImageUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        UserListViewModelImpl(
            reducer = UserListReducer(get(), get()),
            useCases = setOf(
                get<GetUsersUseCase>(),
                get<AddUsersUseCase>(),
            ),
            navigator = get()
        )
    }

    viewModel {
        UserRandomFirstViewModelImpl(
            reducer = UserRandomFirstReducer(get()),
            useCases = setOf(
                get<GetRandomUserFirstUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        UserRandomSecondViewModelImpl(
            reducer = UserRandomSecondReducer(get()),
            useCases = setOf(
                get<GetRandomUserSecondUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        SettingsViewModelImpl(
            reducer = SettingsReducer(),
            useCases = setOf(
                get<SignOutUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        SettingsFirstViewModelImpl(
            reducer = SettingsFirstReducer(get()),
            useCases = setOf(
                get<GetTextSettingsFirstUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        SettingsSecondViewModelImpl(
            reducer = SettingsSecondReducer(get()),
            useCases = setOf(
                get<GetTextSettingsSecondUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        StatisticsViewModelImpl(
            reducer = StatisticsReducer(get()),
            useCases = setOf(
                get<GetModelStatsStatisticsUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        StatisticsFirstViewModelImpl(
            reducer = StatisticsFirstReducer(get()),
            useCases = setOf(
                get<GetModelDataStatFirstUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        StatisticsSecondViewModelImpl(
            reducer = StatisticsSecondReducer(get()),
            useCases = setOf(
                get<GetModelToSecondChartUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        RandomAnimeImageFirstViewModelImpl(
            reducer = RandomAnimeImageFirstReducer(get()),
            useCases = setOf(
                get<GetAnimeImageFirstUseCase>()
            ),
            navigator = get()
        )
    }

    viewModel {
        RandomAnimeImageSecondViewModelImpl(
            reducer = RandomAnimeImageSecondReducer(get()),
            useCases = setOf(
                get<GetAnimeImageSecondUseCase>()
            ),
            navigator = get()
        )
    }
}