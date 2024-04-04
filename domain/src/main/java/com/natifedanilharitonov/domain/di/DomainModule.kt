package com.natifedanilharitonov.domain.di

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
import org.koin.dsl.module

val domainModule = module {
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
