package com.natifedanilharitonov.hardskillsproject.presentation.userList

import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.toUi
import com.natifeuaandroid.domainmodule.features.userList.UserListState
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

data class UserListUiState(
    val userList: PersistentList<UiUser>? = persistentListOf(),
    val canPaging: Boolean = false,
    val pagingState: Boolean = false,
)

fun UserListState.toUi(): UserListUiState {
    return UserListUiState(
        userList = userList?.map { it.toUi() }?.toPersistentList(),
        canPaging = canPaging,
        pagingState = pagingState
    )
}