package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model

import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult
import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.toUi

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
