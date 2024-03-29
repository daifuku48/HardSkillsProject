package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import kotlinx.collections.immutable.PersistentList

interface UserListUiModel {
    data object Pending : UserListUiModel
    data class List(val userList: PersistentList<UiUser>) : UserListUiModel
    data object ErrorList : UserListUiModel
}