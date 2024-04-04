package com.natifedanilharitonov.hardskillsproject.di

import com.natifedanilharitonov.domain.features.info.model.InfoEmailResult
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.main_activity.StartDestinationResult
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage
import com.natifedanilharitonov.domain.features.statistics.StatModel
import com.natifedanilharitonov.domain.features.statistics_second.DoubleStatModel
import com.natifedanilharitonov.domain.features.user_list.UserListResult
import com.natifedanilharitonov.domain.features.user_list.UserPaginationResult
import com.natifedanilharitonov.domain.features.user_random_first.UserResult
import com.natifedanilharitonov.hardskillsproject.presentation.activities.model.StartDestinationMapper
import com.natifedanilharitonov.hardskillsproject.presentation.activities.model.StartDestinationUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailMapper
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailUiState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelMapper
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelMapper
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiMapper
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiMapper
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModelMapper
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.DoubleStatUiMapper
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.DoubleStatUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiMapper
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiMapper
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultMapper
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultUiModel
import org.koin.dsl.module

val mapperModule = module {
    factory<DoubleStatModel.Mapper<DoubleStatUiModel>> {
        DoubleStatUiMapper()
    }

    factory<StatModel.Mapper<StatUiModel>> {
        StatUiModelMapper()
    }

    factory<AnimeImage.Mapper<AnimeImageUiModel>> {
        AnimeImageUiMapper()
    }

    factory<EmailValidationResult.Mapper<EmailLabelState>> {
        EmailLabelMapper()
    }

    factory<PasswordValidationResult.Mapper<PasswordLabelState>> {
        PasswordLabelMapper()
    }

    factory<InfoEmailResult.Mapper<InfoEmailUiState>> {
        InfoEmailMapper()
    }

    factory<StateText.Mapper<StateTextUiModel>> {
        StateTextUiMapper()
    }

    factory<UserListResult.Mapper<UserListUiModel>> {
        UserListUiMapper()
    }

    factory<StartDestinationResult.Mapper<StartDestinationUiModel>> {
        StartDestinationMapper()
    }

    factory<InfoEmailResult.Mapper<InfoEmailUiState>> {
        InfoEmailMapper()
    }

    factory<DoubleStatModel.Mapper<DoubleStatUiModel>> {
        DoubleStatUiMapper()
    }

    factory<UserResult.Mapper<UserResultUiModel>> {
        UserResultMapper()
    }

    factory<UserPaginationResult.Mapper<UserPaginationUiModel>> {
        UserPaginationUiMapper()
    }
}