package com.natifeuaandroid.domainmodule.features.login

sealed class LoginEvent {
    data class EmailChangedEvent(val email: String) : LoginEvent()

    data class PasswordChangedEvent(val password: String) : LoginEvent()

    data object LoginUserEvent : LoginEvent()

    data object UserHasLoggedEvent : LoginEvent()

    data object ValidationEvent : LoginEvent()

    data class EmailPasswordValidationEmail(
        val emailValid: Boolean,
        val passwordValidation: Boolean,
        val buttonEnabled: Boolean,
    ) : LoginEvent()

    data object ShowUserErrorLoginDialog : LoginEvent()

    data object HideUserErrorLoginDialog : LoginEvent()

    data object HideUserHasLoggedDialog : LoginEvent()

    data object ErrorEvent : LoginEvent()

    data object ClearTextFields : LoginEvent()
}
