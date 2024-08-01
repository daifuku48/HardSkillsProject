package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifeuaandroid.domainmodule.features.login.LoginState

data class LoginUiState(
    val email: String,
    val password: String,
    val emailLabelValid: Boolean,
    val passwordLabelValid: Boolean,
    val pending: Boolean,
    val showUserHasLoggedDialog: Boolean,
    val showUserErrorLoginDialog: Boolean,
    val loginButtonEnabled: Boolean,
)

fun LoginState.toUi(): LoginUiState {
    return LoginUiState(
        email = emailText,
        password = passwordText,
        emailLabelValid = emailLabelValid,
        passwordLabelValid = passwordLabelValid,
        pending = pending,
        showUserHasLoggedDialog = showUserHasLoggedDialog,
        showUserErrorLoginDialog = showUserErrorLoginDialog,
        loginButtonEnabled = loginButtonEnabled
    )
}