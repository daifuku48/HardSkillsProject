package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

sealed class UserListEvent : UiEvent {
    data object GetUsersEvent : UserListEvent()
    data object PagingToEndEvent : UserListEvent()
    data class PagingUserIsReceived(val userList: PersistentList<DomainUser>) : UserListEvent()
    data class UsersIsReceived(val userList: UserList) : UserListEvent()
    data object ErrorEvent : UserListEvent()
}