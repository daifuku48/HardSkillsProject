package com.natifedanilharitonov.domain.features.userList

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

sealed class UserListEvent : UiEvent {
    data object GetUsersEvent : UserListEvent()

    data object PagingToEndEvent : UserListEvent()

    data class PagingUserIsReceived(
        val userList: PersistentList<DomainUser>,
        val pagingValue: Int,
    ) : UserListEvent()

    data class UsersIsReceived(
        val userList: UserListResult,
        val pagingValue: Int,
    ) : UserListEvent()

    data object ErrorEvent : UserListEvent()
}
