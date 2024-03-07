package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class RegistrationEvent : UiEvent {
    data class NicknameChangedEvent(val nickname: String) : RegistrationEvent()
    data object NicknameValidationEvent : RegistrationEvent()
    data class NicknameValidationLabelReceived(val label: String, val color: Color) :
        RegistrationEvent()

    data class EmailChangedEvent(val email: String) : RegistrationEvent()
    data object EmailValidationEvent : RegistrationEvent()
    data class EmailValidationLabelReceived(val label: String, val color: Color) :
        RegistrationEvent()

    data class PasswordChangedEvent(val password: String) : RegistrationEvent()
    data object PasswordValidationEvent : RegistrationEvent()
    data class PasswordValidationLabelReceived(val label: String, val color: Color) :
        RegistrationEvent()

    data object RegisterUserEvent : RegistrationEvent()
    data object NavigateToLoginUserEvent : RegistrationEvent()
    data object ShowUserErrorRegistrationDialog : RegistrationEvent()
    data object HideUserErrorRegistrationDialog : RegistrationEvent()
    data object HideUserHasLoggedDialog : RegistrationEvent()
    data object ErrorEvent : RegistrationEvent()
}