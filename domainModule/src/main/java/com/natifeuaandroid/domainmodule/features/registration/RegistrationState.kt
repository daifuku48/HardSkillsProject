package com.natifeuaandroid.domainmodule.features.registration

data class RegistrationState(
    val email: String = "",
    val password: String = "",
    val emailLabel: Boolean = true,
    val passwordLabel: Boolean = true,
    val pending: Boolean = false,
    val registerButtonEnabled: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorRegisterDialog: Boolean = false,
)
