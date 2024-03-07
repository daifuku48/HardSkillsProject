package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class LoginReducer : Reducer<LoginState, LoginEvent> {
    override fun reduce(state: LoginState, event: LoginEvent): LoginState {
        return when (event) {
            is LoginEvent.EmailChangedEvent -> state.copy(email = event.email)
            is LoginEvent.EmailValidationEvent -> state
            is LoginEvent.EmailValidationLabelReceived -> state.copy(
                emailLabel = event.label,
                emailLabelColor = event.color
            )

            is LoginEvent.ErrorEvent -> state
            is LoginEvent.LoginUserEvent -> state.copy(pending = true)
            is LoginEvent.PasswordChangedEvent -> state.copy(password = event.password)
            is LoginEvent.PasswordValidationEvent -> state
            is LoginEvent.PasswordValidationLabelReceived -> state.copy(
                passwordLabel = event.label,
                passwordLabelColor = event.color
            )

            is LoginEvent.UserHasLoggedEvent -> state.copy(
                showUserHasLoggedDialog = true,
                pending = false
            )

            is LoginEvent.HideUserHasLoggedDialog -> state.copy(showUserHasLoggedDialog = false)
            is LoginEvent.HideUserErrorLoginDialog -> state.copy(showUserErrorLoginDialog = false)
            is LoginEvent.ShowUserErrorLoginDialog -> state.copy(
                showUserErrorLoginDialog = true,
                pending = false
            )
        }
    }
}