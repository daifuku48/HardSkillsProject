package com.natifedanilharitonov.domain.features.userRandomSecond

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult

data class UserRandomSecondState(
    val userResult: UserResult = UserResult.Pending,
) : UiState
