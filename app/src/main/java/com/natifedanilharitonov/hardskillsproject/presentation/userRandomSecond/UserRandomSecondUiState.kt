package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.toUi
import com.natifeuaandroid.domainmodule.features.userRandomSecond.UserRandomSecondState


data class UserRandomSecondUiState(
    val userResult: UiUser?,
    val showError: Boolean,
    val isPending: Boolean,
)

fun UserRandomSecondState.toUi(): UserRandomSecondUiState {
    return UserRandomSecondUiState(
        userResult = userResult?.toUi(),
        showError = showError,
        isPending = isPending
    )
}
