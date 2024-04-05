package com.natifedanilharitonov.domain.features.userRandomFirst

import com.natifedanilharitonov.core.UiState

data class UserRandomFirstState(
    val userResult: UserResult = UserResult.Pending,
) : UiState
