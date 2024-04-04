package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.PersistentList

@Stable
interface UserListUiModel {
    data object Pending : UserListUiModel
    data class List(val userList: PersistentList<UiUser>) : UserListUiModel
    data object ErrorList : UserListUiModel
}