package com.natifeuaandroid.domainmodule.features.registration

sealed class RegistrationEvent {
    data class EmailChangedEvent(val email: String) : RegistrationEvent()

    data object ValidationEvent : RegistrationEvent()

    data class EmailPasswordValidationLabelReceived(
        val labelEmail: Boolean,
        val labelPassword: Boolean,
        val buttonEnabled: Boolean,
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
