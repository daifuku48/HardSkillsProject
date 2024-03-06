package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.UiEvent

sealed class LoginEvent : UiEvent {
    data class EmailChangedEvent(val email: String) : LoginEvent()
    data class PasswordChangedEvent(val password: String) : LoginEvent()
    data object LoginUserEvent : LoginEvent()
    data object UserHasLoggedEvent : LoginEvent()
    data class EmailValidationEvent(val validation: Boolean) : LoginEvent()
    data class PasswordValidationEvent(val validation: Boolean) : LoginEvent()
    data object ShowUserErrorLoginDialog : LoginEvent()
    data object HideUserErrorLoginDialog : LoginEvent()
    data object HideUserHasLoggedDialog : LoginEvent()
    data object ErrorEvent : LoginEvent()
}