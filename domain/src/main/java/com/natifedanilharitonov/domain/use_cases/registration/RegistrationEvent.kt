package com.natifedanilharitonov.domain.use_cases.registration

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.use_cases.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.use_cases.login.model.PasswordValidationResult

sealed class RegistrationEvent : UiEvent {
    data class EmailChangedEvent(val email: String) : RegistrationEvent()
    data object ValidationEvent : RegistrationEvent()
    data class EmailPasswordValidationLabelReceived(
        val labelEmail: EmailValidationResult,
        val labelPassword: PasswordValidationResult,
        val buttonEnabled: Boolean
    ) : RegistrationEvent()

    data class PasswordChangedEvent(val password: String) : RegistrationEvent()

    data object RegisterUserEvent : RegistrationEvent()
    data object NavigateToLoginUserEvent : RegistrationEvent()
    data object ShowUserHasLoggedDialog : RegistrationEvent()
    data object HideUserHasRegisteredDialog : RegistrationEvent()
    data object ShowUserErrorRegistrationDialog : RegistrationEvent()
    data object HideUserErrorRegistrationDialog : RegistrationEvent()
    data object ErrorEvent : RegistrationEvent()
}