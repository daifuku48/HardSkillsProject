package com.natifedanilharitonov.domain.features.user_random_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.user_random_first.UserResult

data class UserRandomSecondState(
    val userResult: UserResult = UserResult.Pending
) : UiState