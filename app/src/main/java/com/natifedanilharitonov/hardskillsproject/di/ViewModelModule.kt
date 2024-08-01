package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.hardskillsproject.presentation.activities.MainActivityViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.infoFirst.InfoFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.infoSecond.InfoSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.mainFirst.MainFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.mainSecond.MainSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.RandomAnimeImageViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst.RandomAnimeImageFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond.RandomAnimeImageSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settings.SettingsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst.SettingsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond.SettingsSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.StatisticsViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.StatisticsFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.StatisticsSecondViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userList.UserListViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.UserRandomFirstViewModelImpl
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond.UserRandomSecondViewModelImpl
import com.natifeuaandroid.domainmodule.features.info.InfoReducer
import com.natifeuaandroid.domainmodule.features.info.useCases.GetUserInfoUseCase
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstReducer
import com.natifeuaandroid.domainmodule.features.infoFirst.useCases.GetTextFirstInfoUseCase
import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondReducer
import com.natifeuaandroid.domainmodule.features.infoSecond.useCases.GetTextSecondInfoUseCase
import com.natifeuaandroid.domainmodule.features.login.LoginReducer
import com.natifeuaandroid.domainmodule.features.login.useCases.EmailPasswordLoginValidationUseCase
import com.natifeuaandroid.domainmodule.features.login.useCases.LoginUserUseCase
import com.natifeuaandroid.domainmodule.features.main.MainReducer
import com.natifeuaandroid.domainmodule.features.main.useCases.GetMainTextUseCase
import com.natifeuaandroid.domainmodule.features.mainActivity.GetStartDestinationUseCase
import com.natifeuaandroid.domainmodule.features.mainActivity.MainActivityReducer
import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstReducer
import com.natifeuaandroid.domainmodule.features.mainFirst.useCases.GetTextFirstMainUseCase
import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondReducer
import com.natifeuaandroid.domainmodule.features.mainSecond.useCases.GetTextSecondMainUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageReducer
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.useCases.GetAnimeImageUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstReducer
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.useCases.GetAnimeImageFirstUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondReducer
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.useCases.GetAnimeImageSecondUseCase
import com.natifeuaandroid.domainmodule.features.registration.RegistrationReducer
import com.natifeuaandroid.domainmodule.features.registration.useCases.EmailPasswordValidationRegistrationUseCase
import com.natifeuaandroid.domainmodule.features.registration.useCases.RegisterUserUseCase
import com.natifeuaandroid.domainmodule.features.settings.SettingsReducer
import com.natifeuaandroid.domainmodule.features.settings.useCases.SignOutUseCase
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstReducer
import com.natifeuaandroid.domainmodule.features.settingsFirst.useCases.GetTextSettingsFirstUseCase
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondReducer
import com.natifeuaandroid.domainmodule.features.settingsSecond.useCases.GetTextSettingsSecondUseCase
import com.natifeuaandroid.domainmodule.features.statistics.StatisticsReducer
import com.natifeuaandroid.domainmodule.features.statistics.useCases.GetModelStatsStatisticsUseCase
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstReducer
import com.natifeuaandroid.domainmodule.features.statisticsFirst.useCases.GetModelDataStatFirstUseCase
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondReducer
import com.natifeuaandroid.domainmodule.features.statisticsSecond.useCases.GetModelToSecondChartUseCase
import com.natifeuaandroid.domainmodule.features.userList.UserListReducer
import com.natifeuaandroid.domainmodule.features.userList.useCases.AddUsersUseCase
import com.natifeuaandroid.domainmodule.features.userList.useCases.GetUsersUseCase
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstReducer
import com.natifeuaandroid.domainmodule.features.userRandomFirst.useCases.GetRandomUserFirstUseCase
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondReducer
import com.natifeuaandroid.domainmodule.features.userRandomSecond.useCases.GetRandomUserSecondUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel {
            LoginViewModelImpl(
                reducer = LoginReducer(),
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
                reducer = RegistrationReducer(),
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
                reducer = MainActivityReducer(),
                useCases =
                setOf(
                    get<GetStartDestinationUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            MainViewModelImpl(
                reducer = MainReducer(),
                useCases =
                setOf(
                    get<GetMainTextUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            MainFirstViewModelImpl(
                reducer = MainFirstReducer(),
                useCases =
                setOf(
                    get<GetTextFirstMainUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            MainSecondViewModelImpl(
                reducer = MainSecondReducer(),
                useCases =
                setOf(
                    get<GetTextSecondMainUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            InfoViewModelImpl(
                reducer = InfoReducer(),
                useCases =
                setOf(
                    get<GetUserInfoUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            InfoFirstViewModelImpl(
                reducer = InfoFirstReducer(),
                useCases =
                setOf(
                    get<GetTextFirstInfoUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            InfoSecondViewModelImpl(
                reducer = InfoSecondReducer(),
                useCases =
                setOf(
                    get<GetTextSecondInfoUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageViewModelImpl(
                reducer = RandomAnimeImageReducer(),
                useCases =
                setOf(
                    get<GetAnimeImageUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            UserListViewModelImpl(
                reducer = UserListReducer(),
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
                reducer = UserRandomFirstReducer(),
                useCases =
                setOf(
                    get<GetRandomUserFirstUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            UserRandomSecondViewModelImpl(
                reducer = UserRandomSecondReducer(),
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
                reducer = SettingsFirstReducer(),
                useCases =
                setOf(
                    get<GetTextSettingsFirstUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            SettingsSecondViewModelImpl(
                reducer = SettingsSecondReducer(),
                useCases =
                setOf(
                    get<GetTextSettingsSecondUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsViewModelImpl(
                reducer = StatisticsReducer(),
                useCases =
                setOf(
                    get<GetModelStatsStatisticsUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsFirstViewModelImpl(
                reducer = StatisticsFirstReducer(),
                useCases =
                setOf(
                    get<GetModelDataStatFirstUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            StatisticsSecondViewModelImpl(
                reducer = StatisticsSecondReducer(),
                useCases =
                setOf(
                    get<GetModelToSecondChartUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageFirstViewModelImpl(
                reducer = RandomAnimeImageFirstReducer(),
                useCases =
                setOf(
                    get<GetAnimeImageFirstUseCase>(),
                ),
                navigator = get(),
            )
        }

        viewModel {
            RandomAnimeImageSecondViewModelImpl(
                reducer = RandomAnimeImageSecondReducer(),
                useCases =
                setOf(
                    get<GetAnimeImageSecondUseCase>(),
                ),
                navigator = get(),
            )
        }
    }
