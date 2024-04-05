package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel

data class UserRandomSecondUiState(
    val userResult: UserResultUiModel = UserResultUiModel.Pending,
) : UiModel
