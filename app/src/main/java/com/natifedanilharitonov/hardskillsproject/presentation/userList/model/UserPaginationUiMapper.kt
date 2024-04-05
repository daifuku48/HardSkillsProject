package com.natifedanilharitonov.hardskillsproject.presentation.userList.model

import com.natifedanilharitonov.domain.features.userList.UserPaginationResult

class UserPaginationUiMapper : UserPaginationResult.Mapper<UserPaginationUiModel> {
    override fun mapPaging(): UserPaginationUiModel {
        return UserPaginationUiModel.Paging
    }

    override fun mapIdle(): UserPaginationUiModel {
        return UserPaginationUiModel.Idle
    }
}
