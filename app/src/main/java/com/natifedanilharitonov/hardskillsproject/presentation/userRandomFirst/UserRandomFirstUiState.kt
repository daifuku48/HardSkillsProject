package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst

import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.toUi
import com.natifeuaandroid.domainmodule.features.userRandomFirst.UserRandomFirstState

data class UserRandomFirstUiState(
    val userResult: UiUser?,
    val isPending: Boolean,
)

fun UserRandomFirstState.toUi(): UserRandomFirstUiState {
    return UserRandomFirstUiState(userResult = userResult?.toUi(), isPending = isPending)
}
