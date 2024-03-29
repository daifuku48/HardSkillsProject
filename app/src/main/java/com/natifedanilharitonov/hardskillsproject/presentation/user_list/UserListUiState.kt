package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel

data class UserListUiState(
    val userList: UserListUiModel = UserListUiModel.Pending
) : UiModel