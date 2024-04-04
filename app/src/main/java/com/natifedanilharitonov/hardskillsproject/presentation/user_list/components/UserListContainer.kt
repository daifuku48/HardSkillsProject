package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiModel

@Composable
fun UserListContainer(
    userList: UserListUiModel,
    addUsers: () -> Unit,
    pagingValue: Boolean,
    pagingState: UserPaginationUiModel,
    backToMain: () -> Unit
) {
    when (userList) {
        UserListUiModel.ErrorList -> {
            ErrorListScreen()
        }

        is UserListUiModel.List -> {
            UserListColumn(
                userList = userList.userList,
                addUsers = addUsers,
                canPaging = pagingValue,
                pagingState = pagingState
            )
            MainButton(text = stringResource(id = R.string.back_to_main), onClick = backToMain)
        }

        UserListUiModel.Pending -> {
            PendingListScreen()
        }
    }
}

