package com.natifeuaandroid.domainmodule.di


import com.natifeuaandroid.domainmodule.features.info.useCases.GetUserInfoUseCase
import com.natifeuaandroid.domainmodule.features.infoFirst.useCases.GetTextFirstInfoUseCase
import com.natifeuaandroid.domainmodule.features.infoSecond.useCases.GetTextSecondInfoUseCase
import com.natifeuaandroid.domainmodule.features.login.useCases.EmailPasswordLoginValidationUseCase
import com.natifeuaandroid.domainmodule.features.login.useCases.LoginUserUseCase
import com.natifeuaandroid.domainmodule.features.main.useCases.GetMainTextUseCase
import com.natifeuaandroid.domainmodule.features.mainActivity.GetStartDestinationUseCase
import com.natifeuaandroid.domainmodule.features.mainFirst.useCases.GetTextFirstMainUseCase
import com.natifeuaandroid.domainmodule.features.mainSecond.useCases.GetTextSecondMainUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.useCases.GetAnimeImageUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.useCases.GetAnimeImageFirstUseCase
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.useCases.GetAnimeImageSecondUseCase
import com.natifeuaandroid.domainmodule.features.registration.useCases.EmailPasswordValidationRegistrationUseCase
import com.natifeuaandroid.domainmodule.features.registration.useCases.RegisterUserUseCase
import com.natifeuaandroid.domainmodule.features.settings.useCases.SignOutUseCase
import com.natifeuaandroid.domainmodule.features.settingsFirst.useCases.GetTextSettingsFirstUseCase
import com.natifeuaandroid.domainmodule.features.settingsSecond.useCases.GetTextSettingsSecondUseCase
import com.natifeuaandroid.domainmodule.features.statistics.useCases.GetModelStatsStatisticsUseCase
import com.natifeuaandroid.domainmodule.features.statisticsFirst.useCases.GetModelDataStatFirstUseCase
import com.natifeuaandroid.domainmodule.features.statisticsSecond.useCases.GetModelToSecondChartUseCase
import com.natifeuaandroid.domainmodule.features.userList.useCases.AddUsersUseCase
import com.natifeuaandroid.domainmodule.features.userList.useCases.GetUsersUseCase
import com.natifeuaandroid.domainmodule.features.userRandomFirst.useCases.GetRandomUserFirstUseCase
import com.natifeuaandroid.domainmodule.features.userRandomSecond.useCases.GetRandomUserSecondUseCase
import org.koin.dsl.module

val domainModule =
    module {
        factory {
            EmailPasswordLoginValidationUseCase()
        }

        factory {
            EmailPasswordValidationRegistrationUseCase()
        }

        factory {
            LoginUserUseCase(get())
        }

        factory {
            RegisterUserUseCase(get())
        }

        factory {
            GetStartDestinationUseCase(get())
        }

        factory {
            GetUserInfoUseCase(get())
        }

        factory {
            GetMainTextUseCase(get())
        }

        factory {
            GetTextFirstMainUseCase(get())
        }

        factory {
            GetTextSecondMainUseCase(get())
        }

        factory {
            SignOutUseCase(get())
        }

        factory {
            GetTextSettingsFirstUseCase(get())
        }

        factory {
            GetTextSettingsSecondUseCase(get())
        }

        factory {
            GetAnimeImageUseCase(get())
        }

        factory {
            GetModelStatsStatisticsUseCase(get())
        }

        factory {
            GetModelDataStatFirstUseCase(get())
        }

        factory {
            GetUsersUseCase(get())
        }

        factory {
            GetModelToSecondChartUseCase(get())
        }

        factory {
            GetAnimeImageFirstUseCase(get())
        }

        factory {
            GetAnimeImageSecondUseCase(get())
        }

        factory {
            GetTextFirstInfoUseCase(get())
        }

        factory {
            GetTextSecondInfoUseCase(get())
        }

        factory {
            GetRandomUserFirstUseCase(get())
        }

        factory {
            GetRandomUserSecondUseCase(get())
        }

        factory {
            AddUsersUseCase(get())
        }
    }
