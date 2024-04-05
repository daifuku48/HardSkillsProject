package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model

import com.natifedanilharitonov.core.UiModel

data class UserRandomFirstUiState(
    val userResult: UserResultUiModel = UserResultUiModel.Pending,
) : UiModel
