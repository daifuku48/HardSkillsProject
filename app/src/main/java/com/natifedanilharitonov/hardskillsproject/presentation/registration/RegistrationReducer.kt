package com.natifedanilharitonov.hardskillsproject.presentation.registration

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class RegistrationReducer : Reducer<RegistrationState, RegistrationEvent> {
    override fun reduce(state: RegistrationState, event: RegistrationEvent): RegistrationState {
        return when (event) {
            is RegistrationEvent.EmailChangedEvent -> state.copy(email = event.email)
            RegistrationEvent.ValidationEvent -> state
            is RegistrationEvent.EmailPasswordValidationLabelReceived -> state.copy(
                emailLabel = event.labelEmail,
                emailLabelColor = event.colorLabelEmail,
                passwordLabel = event.labelPassword,
                passwordLabelColor = event.colorLabelPassword,
                registerButtonEnabled = event.buttonEnabled
            )

            RegistrationEvent.ErrorEvent -> state
            RegistrationEvent.HideUserErrorRegistrationDialog -> state.copy(
                showUserErrorRegisterDialog = false
            )

            RegistrationEvent.NavigateToLoginUserEvent -> state
            is RegistrationEvent.PasswordChangedEvent -> state.copy(password = event.password)
            RegistrationEvent.RegisterUserEvent -> state.copy(pending = true)
            RegistrationEvent.ShowUserErrorRegistrationDialog -> state.copy(
                showUserErrorRegisterDialog = true,
                pending = false
            )

            RegistrationEvent.HideUserHasRegisteredDialog -> state.copy(showUserHasLoggedDialog = false)
            RegistrationEvent.ShowUserHasLoggedDialog -> state.copy(
                showUserHasLoggedDialog = true,
                pending = false
            )
        }
    }
}