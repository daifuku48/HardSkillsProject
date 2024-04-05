package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailLabel: EmailLabelState = EmailLabelState.ValidEmailLabel,
    val passwordLabel: PasswordLabelState = PasswordLabelState.ValidPassword,
    val pending: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false,
    val loginButtonEnabled: Boolean = false,
) : UiModel
