package com.natifedanilharitonov.hardskillsproject.presentation.userList

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UserPaginationUiModel

data class UserListUiState(
    val userList: UserListUiModel = UserListUiModel.Pending,
    val canPaging: Boolean = false,
    val pagingState: UserPaginationUiModel = UserPaginationUiModel.Idle,
) : UiModel
