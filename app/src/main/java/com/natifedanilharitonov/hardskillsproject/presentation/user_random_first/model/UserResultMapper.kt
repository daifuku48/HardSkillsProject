package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model

import com.natifedanilharitonov.domain.features.user_random_first.UserResult
import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.toUi

class UserResultMapper : UserResult.Mapper<UserResultUiModel> {
    override fun mapPending(): UserResultUiModel {
        return UserResultUiModel.Pending
    }

    override fun mapModel(user: DomainUser): UserResultUiModel {
        return UserResultUiModel.Model(user.toUi())
    }

    override fun mapError(): UserResultUiModel {
        return UserResultUiModel.Error
    }
}