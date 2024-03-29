package com.natifedanilharitonov.domain.use_cases.user_list

import com.natifedanilharitonov.core.UiEvent
import kotlinx.collections.immutable.PersistentList

sealed class UserListEvent : UiEvent {
    data object GetUsersEvent : UserListEvent()
    data object PagingToEndEvent : UserListEvent()
    data class PagingUserIsReceived(val userList: PersistentList<com.natifedanilharitonov.domain.model.DomainUser>) : UserListEvent()
    data class UsersIsReceived(val userList: UserListResult) : UserListEvent()
    data object ErrorEvent : UserListEvent()
}