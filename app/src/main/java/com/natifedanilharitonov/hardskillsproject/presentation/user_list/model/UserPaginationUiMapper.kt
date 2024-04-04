package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import com.natifedanilharitonov.domain.features.user_list.UserPaginationResult

class UserPaginationUiMapper : UserPaginationResult.Mapper<UserPaginationUiModel> {
    override fun mapPaging(): UserPaginationUiModel {
        return UserPaginationUiModel.Paging
    }

    override fun mapIdle(): UserPaginationUiModel {
        return UserPaginationUiModel.Idle
    }
}