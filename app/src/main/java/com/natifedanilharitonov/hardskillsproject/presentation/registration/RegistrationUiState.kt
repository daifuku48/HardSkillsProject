package com.natifedanilharitonov.hardskillsproject.presentation.registration

import com.natifeuaandroid.domainmodule.features.registration.RegistrationState

data class RegistrationUiState(
    val email: String,
    val password: String,
    val emailLabel: Boolean,
    val passwordLabel: Boolean,
    val pending: Boolean,
    val registerButtonEnabled: Boolean,
    val showUserHasLoggedDialog: Boolean,
    val showUserErrorRegisterDialog: Boolean,
)

fun RegistrationState.toUi(): RegistrationUiState {
    return RegistrationUiState(
        email = email,
        password = password,
        emailLabel = emailLabel,
        passwordLabel = passwordLabel,
        pending = pending,
        registerButtonEnabled = registerButtonEnabled,
        showUserHasLoggedDialog = showUserHasLoggedDialog,
        showUserErrorRegisterDialog = showUserErrorRegisterDialog
    )
}