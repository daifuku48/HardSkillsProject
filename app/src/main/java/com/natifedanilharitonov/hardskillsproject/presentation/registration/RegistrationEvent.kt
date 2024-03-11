package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class RegistrationEvent : UiEvent {
    data class EmailChangedEvent(val email: String) : RegistrationEvent()
    data object ValidationEvent : RegistrationEvent()
    data class EmailPasswordValidationLabelReceived(
        val labelEmail: String,
        val colorLabelEmail: Color,
        val labelPassword: String,
        val colorLabelPassword: Color,
        val buttonEnabled: Boolean
    ) :
        RegistrationEvent()

    data class PasswordChangedEvent(val password: String) : RegistrationEvent()

    data object RegisterUserEvent : RegistrationEvent()
    data object NavigateToLoginUserEvent : RegistrationEvent()
    data object ShowUserHasLoggedDialog : RegistrationEvent()
    data object HideUserHasRegisteredDialog : RegistrationEvent()
    data object ShowUserErrorRegistrationDialog : RegistrationEvent()
    data object HideUserErrorRegistrationDialog : RegistrationEvent()
    data object ErrorEvent : RegistrationEvent()
}