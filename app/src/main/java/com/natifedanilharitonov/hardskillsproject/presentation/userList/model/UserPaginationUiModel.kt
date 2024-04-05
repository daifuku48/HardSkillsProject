package com.natifedanilharitonov.hardskillsproject.presentation.userList.model

import androidx.compose.runtime.Stable

@Stable
interface UserPaginationUiModel {
    data object Paging : UserPaginationUiModel

    data object Idle : UserPaginationUiModel
}
