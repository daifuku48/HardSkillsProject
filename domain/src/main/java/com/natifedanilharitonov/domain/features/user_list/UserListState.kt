package com.natifedanilharitonov.domain.features.user_list

import com.natifedanilharitonov.core.UiState

data class UserListState(
    val userList: UserListResult = UserListResult.Pending,
    val canPaging: Boolean = false,
    val pagingState: UserPaginationResult = UserPaginationResult.Idle
) : UiState