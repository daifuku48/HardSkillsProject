package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiModel

data class UserListUiState(
    val userList: UserListUiModel = UserListUiModel.Pending,
    val canPaging: Boolean = false,
    val pagingState: UserPaginationUiModel = UserPaginationUiModel.Idle
) : UiModel