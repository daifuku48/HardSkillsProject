package com.natifedanilharitonov.domain.features.user_random_first

import com.natifedanilharitonov.core.UiState

data class UserRandomFirstState(
    val userResult: UserResult = UserResult.Pending
) : UiState