package com.natifedanilharitonov.domain.di

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
