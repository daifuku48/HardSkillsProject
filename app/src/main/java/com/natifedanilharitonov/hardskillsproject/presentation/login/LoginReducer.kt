package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class LoginReducer : Reducer<LoginState, LoginEvent> {
    override fun reduce(state: LoginState, event: LoginEvent): LoginState {
        return when (event) {
            is LoginEvent.EmailChangedEvent -> state.copy(email = event.email)
            is LoginEvent.ValidationEvent -> state
            is LoginEvent.ErrorEvent -> state
            is LoginEvent.LoginUserEvent -> state.copy(pending = true)
            is LoginEvent.PasswordChangedEvent -> state.copy(password = event.password)

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

            is LoginEvent.EmailPasswordValidationEmail -> state.copy(
                emailLabel = event.labelEmail,
                emailLabelColor = event.colorLabelEmail,
                passwordLabel = event.labelPassword,
                passwordLabelColor = event.colorLabelPassword,
                loginButtonEnabled = event.buttonEnabled
            )
        }
    }
}