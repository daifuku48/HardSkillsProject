package com.natifeuaandroid.domainmodule.features.registration

import com.natifeuaandroid.coremodule.Reducer


class RegistrationReducer : Reducer<RegistrationState, RegistrationEvent> {
    override fun reduce(
        state: RegistrationState,
        event: RegistrationEvent,
    ): RegistrationState {
        return when (event) {
            is RegistrationEvent.EmailChangedEvent -> state.copy(email = event.email)
            RegistrationEvent.ValidationEvent -> state
            is RegistrationEvent.EmailPasswordValidationLabelReceived ->
                state.copy(
                    emailLabel = event.labelEmail,
                    passwordLabel = event.labelPassword,
                    registerButtonEnabled = event.buttonEnabled,
                )

            RegistrationEvent.ErrorEvent -> state
            RegistrationEvent.HideUserErrorRegistrationDialog ->
                state.copy(
                    showUserErrorRegisterDialog = false,
                )

            RegistrationEvent.NavigateToLoginUserEvent -> state
            is RegistrationEvent.PasswordChangedEvent -> state.copy(password = event.password)
            RegistrationEvent.RegisterUserEvent -> state.copy(pending = true)
            RegistrationEvent.ShowUserErrorRegistrationDialog ->
                state.copy(
                    showUserErrorRegisterDialog = true,
                    pending = false,
                    email = "",
                    password = "",
                )

            RegistrationEvent.HideUserHasRegisteredDialog -> state.copy(showUserHasLoggedDialog = false)
            RegistrationEvent.ShowUserHasLoggedDialog ->
                state.copy(
                    showUserHasLoggedDialog = true,
                    pending = false,
                )
        }
    }

    override fun createInitialState(): RegistrationState {
        return RegistrationState()
    }
}
