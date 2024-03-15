package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserList

@Composable
fun UserListContainer(userList: UserList) {
    when (userList) {
        UserList.ErrorList -> {
            ErrorListScreen()
        }

        is UserList.List -> {
            UserListColumn(userList = userList.userList)
        }

        UserList.Pending -> {
            PendingListScreen()
        }
    }
}

