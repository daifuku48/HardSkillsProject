package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class LoginEvent : UiEvent {
    data class EmailChangedEvent(val email: String) : LoginEvent()
    data class PasswordChangedEvent(val password: String) : LoginEvent()
    data object LoginUserEvent : LoginEvent()
    data object UserHasLoggedEvent : LoginEvent()
    data object ValidationEvent : LoginEvent()
    data class EmailPasswordValidationEmail(
        val labelEmail: String,
        val colorLabelEmail: Color,
        val labelPassword: String,
        val colorLabelPassword: Color,
        val buttonEnabled: Boolean
    ) : LoginEvent()

    data object ShowUserErrorLoginDialog : LoginEvent()
    data object HideUserErrorLoginDialog : LoginEvent()
    data object HideUserHasLoggedDialog : LoginEvent()
    data object ErrorEvent : LoginEvent()
    data object ClearTextFields : LoginEvent()
}