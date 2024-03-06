package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class LoginReducer : Reducer<LoginState, LoginEvent> {
    override fun reduce(state: LoginState, event: LoginEvent): LoginState {
        return when (event) {
            is LoginEvent.EmailChangedEvent -> state.copy(email = event.email)
            is LoginEvent.EmailValidationEvent -> state.copy(emailValidation = event.validation)
            LoginEvent.ErrorEvent -> state
            LoginEvent.LoginUserEvent -> state.copy(pending = true)
            is LoginEvent.PasswordChangedEvent -> state.copy(password = event.password)
            is LoginEvent.PasswordValidationEvent -> state.copy(passwordValidation = event.validation)
            LoginEvent.UserHasLoggedEvent -> state.copy(
                showUserHasLoggedDialog = true,
                pending = false
            )

            LoginEvent.HideUserHasLoggedDialog -> state.copy(showUserHasLoggedDialog = false)
            LoginEvent.HideUserErrorLoginDialog -> state.copy(showUserErrorLoginDialog = false)
            LoginEvent.ShowUserErrorLoginDialog -> state.copy(
                showUserErrorLoginDialog = true,
                pending = false
            )
        }
    }
}