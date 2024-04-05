package com.natifedanilharitonov.hardskillsproject.presentation.registration

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

data class RegistrationUiState(
    val email: String = "",
    val password: String = "",
    val emailLabel: EmailLabelState = EmailLabelState.ValidEmailLabel,
    val passwordLabel: PasswordLabelState = PasswordLabelState.ValidPassword,
    val pending: Boolean = false,
    val registerButtonEnabled: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorRegisterDialog: Boolean = false,
) : UiModel
