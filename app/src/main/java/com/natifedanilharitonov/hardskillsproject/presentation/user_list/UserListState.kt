package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

data class UserListState(
    val userList: UserList = UserList.Pending
) : UiState

sealed class UserList {
    data object Pending : UserList()
    data class List(val userList: PersistentList<DomainUser>) : UserList()
    data object ErrorList : UserList()
}