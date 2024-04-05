package com.natifedanilharitonov.domain.features.login

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult

data class LoginState(
    val emailText: String = "",
    val passwordText: String = "",
    val emailState: EmailValidationResult = EmailValidationResult.ValidEmail,
    val passwordState: PasswordValidationResult = PasswordValidationResult.ValidPassword,
    val pending: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false,
    val loginButtonEnabled: Boolean = false,
) : UiState
