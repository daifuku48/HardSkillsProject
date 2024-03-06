package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.UiState

data class LoginState(
    val email: String = "",
    val password: String = "",
    val pending: Boolean = false,
    val emailValidation: Boolean = true,
    val passwordValidation: Boolean = true,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false
) : UiState