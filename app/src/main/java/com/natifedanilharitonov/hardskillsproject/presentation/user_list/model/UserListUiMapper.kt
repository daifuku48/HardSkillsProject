package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.domain.use_cases.user_list.UserListResult
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class UserListUiMapper : UserListResult.Mapper<UserListUiModel> {
    override fun mapPending(): UserListUiModel {
        return UserListUiModel.Pending
    }

    override fun mapList(userList: PersistentList<DomainUser>): UserListUiModel {
        return UserListUiModel.List(userList.map { it.toUi() }.toPersistentList())
    }

    override fun mapError(): UserListUiModel {
        return UserListUiModel.ErrorList
    }
}