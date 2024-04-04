package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model

import com.natifedanilharitonov.core.UiModel

data class UserRandomFirstUiState(
    val userResult: UserResultUiModel = UserResultUiModel.Pending
) : UiModel