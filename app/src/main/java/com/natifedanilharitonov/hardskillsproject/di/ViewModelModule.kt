package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.domain.features.info.GetUserInfoUseCase
import com.natifedanilharitonov.domain.features.infoFirst.GetTextFirstInfoUseCase
import com.natifedanilharitonov.domain.features.infoSecond.GetTextSecondInfoUseCase
import com.natifedanilharitonov.domain.features.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.domain.features.login.LoginUserUseCase
import com.natifedanilharitonov.domain.features.main.GetMainTextUseCase
import com.natifedanilharitonov.domain.features.mainActivity.GetStartDestinationUseCase
import com.natifedanilharitonov.domain.features.mainFirst.GetTextFirstMainUseCase
import com.natifedanilharitonov.domain.features.mainSecond.GetTextSecondMainUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImage.GetAnimeImageUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.GetAnimeImageFirstUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.GetAnimeImageSecondUseCase
import com.natifedanilharitonov.domain.features.registration.EmailPasswordValidationRegistrationUseCase
import com.natifedanilharitonov.domain.features.registration.RegisterUserUseCase
import com.natifedanilharitonov.domain.features.settings.SignOutUseCase
import com.natifedanilharitonov.domain.features.settingsFirst.GetTextSettingsFirstUseCase
import com.natifedanilharitonov.domain.features.settingsSecond.GetTextSettingsSecondUseCase
import com.natifedanilharitonov.domain.features.statistics.GetModelStatsStatisticsUseCase
import com.natifedanilharitonov.domain.features.statisticsFirst.GetModelDataStatFirstUseCase
import com.natifedanilharitonov.domain.features.statisticsSecond.GetModelToSecondChartUseCase
import com.natifedanilharitonov.domain.features.userList.AddUsersUseCase
import com.natifedanilharitonov.domain.features.userList.GetUsersUseCase
import com.natifedanilharitonov.domain.features.userRandomFirst.GetRandomUserFirstUseCase
import com.natifedanilharitonov.domain.features.userRandomSecond.GetRandomUserSecondUseCase
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityReducer
import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoReducer
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.infoFirst.InfoFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.infoFirst.InfoFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.infoSecond.InfoSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.infoSecond.InfoSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginReducer
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainReducer
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.mainFirst.MainFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.mainFirst.MainFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.mainSecond.MainSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.mainSecond.MainSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.RandomAnimeImageReducer
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.RandomAnimeImageViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst.RandomAnimeImageFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst.RandomAnimeImageFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond.RandomAnimeImageSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond.RandomAnimeImageSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationReducer
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst.SettingsFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst.SettingsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond.SettingsSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond.SettingsSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.StatisticsFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.StatisticsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.StatisticsSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.StatisticsSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userList.UserListReducer
import com.natifedanilharitonov.hardskillsproject.presentation.userList.UserListViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.UserRandomFirstReducer
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.UserRandomFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond.UserRandomSecondReducer
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond.UserRandomSecondViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel {
            LoginViewModelImpl(
                reducer = LoginReducer(get(), get()),
                useCases =
                    setOf(
                        get<EmailPasswordLoginValidationUseCase>(),
                        get<LoginUserUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            RegistrationViewModelImpl(
                reducer = RegistrationReducer(get(), get()),
                useCases =
                    setOf(
                        get<EmailPasswordValidationRegistrationUseCase>(),
                        get<RegisterUserUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            MainActivityViewModelImpl(
                reducer = MainActivityReducer(get()),
                useCases =
                    setOf(
                        get<GetStartDestinationUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            MainViewModelImpl(
                reducer = MainReducer(get()),
                useCases =
                    setOf(
                        get<GetMainTextUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            MainFirstViewModelImpl(
                reducer = MainFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetTextFirstMainUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            MainSecondViewModelImpl(
                reducer = MainSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetTextSecondMainUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            InfoViewModelImpl(
                reducer = InfoReducer(get()),
                useCases =
                    setOf(
                        get<GetUserInfoUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            InfoFirstViewModelImpl(
                reducer = InfoFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetTextFirstInfoUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            InfoSecondViewModelImpl(
                reducer = InfoSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetTextSecondInfoUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageViewModelImpl(
                reducer = RandomAnimeImageReducer(get()),
                useCases =
                    setOf(
                        get<GetAnimeImageUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            UserListViewModelImpl(
                reducer = UserListReducer(get(), get()),
                useCases =
                    setOf(
                        get<GetUsersUseCase>(),
                        get<AddUsersUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            UserRandomFirstViewModelImpl(
                reducer = UserRandomFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetRandomUserFirstUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            UserRandomSecondViewModelImpl(
                reducer = UserRandomSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetRandomUserSecondUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            SettingsViewModelImpl(
                reducer = SettingsReducer(),
                useCases =
                    setOf(
                        get<SignOutUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            SettingsFirstViewModelImpl(
                reducer = SettingsFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetTextSettingsFirstUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            SettingsSecondViewModelImpl(
                reducer = SettingsSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetTextSettingsSecondUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsViewModelImpl(
                reducer = StatisticsReducer(get()),
                useCases =
                    setOf(
                        get<GetModelStatsStatisticsUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsFirstViewModelImpl(
                reducer = StatisticsFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetModelDataStatFirstUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsSecondViewModelImpl(
                reducer = StatisticsSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetModelToSecondChartUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageFirstViewModelImpl(
                reducer = RandomAnimeImageFirstReducer(get()),
                useCases =
                    setOf(
                        get<GetAnimeImageFirstUseCase>(),
                    ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageSecondViewModelImpl(
                reducer = RandomAnimeImageSecondReducer(get()),
                useCases =
                    setOf(
                        get<GetAnimeImageSecondUseCase>(),
                    ),
                navigator = get(),
            )
        }
    }
