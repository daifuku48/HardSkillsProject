package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import androidx.compose.runtime.Stable

@Stable
interface UserPaginationUiModel {
    data object Paging : UserPaginationUiModel
    data object Idle : UserPaginationUiModel
}