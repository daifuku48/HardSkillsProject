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
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics.GetModelStatsStatisticsUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics_first.GetModelDataStatFirstUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.statistics_second.GetModelToSecondChartUseCase
import com.natifedanilharitonov.hardskillsproject.domain.use_cases.user_list.GetUsersUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        EmailPasswordLoginValidationUseCase(get())
    }

    factory {
        EmailPasswordValidationRegistrationUseCase(get())
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
        GetUserInfoUseCase(get(), get())
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
}
