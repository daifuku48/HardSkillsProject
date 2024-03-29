package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel

@Composable
fun UserListContainer(userList: UserListUiModel) {
    when (userList) {
        UserListUiModel.ErrorList -> {
            ErrorListScreen()
        }

        is UserListUiModel.List -> {
            UserListColumn(userList = userList.userList)
        }

        UserListUiModel.Pending -> {
            PendingListScreen()
        }
    }
}

