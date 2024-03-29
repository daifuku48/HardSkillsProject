package com.natifedanilharitonov.domain.use_cases.user_list

import com.natifedanilharitonov.core.UiState

data class UserListState(
    val userList: UserListResult = UserListResult.Pending
) : UiState