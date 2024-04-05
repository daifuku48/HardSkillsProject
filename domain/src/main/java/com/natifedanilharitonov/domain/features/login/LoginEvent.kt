package com.natifedanilharitonov.domain.features.login

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult

sealed class LoginEvent : UiEvent {
    data class EmailChangedEvent(val email: String) : LoginEvent()

    data class PasswordChangedEvent(val password: String) : LoginEvent()

    data object LoginUserEvent : LoginEvent()

    data object UserHasLoggedEvent : LoginEvent()

    data object ValidationEvent : LoginEvent()

    data class EmailPasswordValidationEmail(
        val emailValidation: EmailValidationResult,
        val passwordValidation: PasswordValidationResult,
        val buttonEnabled: Boolean,
    ) : LoginEvent()

    data object ShowUserErrorLoginDialog : LoginEvent()

    data object HideUserErrorLoginDialog : LoginEvent()

    data object HideUserHasLoggedDialog : LoginEvent()

    data object ErrorEvent : LoginEvent()

    data object ClearTextFields : LoginEvent()
}
