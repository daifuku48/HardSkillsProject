package com.natifedanilharitonov.hardskillsproject.presentation.user_random_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultUiModel

data class UserRandomSecondUiState(
    val userResult: UserResultUiModel = UserResultUiModel.Pending
) : UiModel