package com.natifeuaandroid.domainmodule.features.login

data class LoginState(
    val emailText: String = "",
    val passwordText: String = "",
    val emailLabelValid: Boolean = true,
    val passwordLabelValid: Boolean = true,
    val pending: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false,
    val loginButtonEnabled: Boolean = false,
)
