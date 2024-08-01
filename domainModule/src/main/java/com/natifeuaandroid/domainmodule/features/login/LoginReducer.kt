package com.natifeuaandroid.domainmodule.features.login

import com.natifeuaandroid.coremodule.Reducer


class LoginReducer : Reducer<LoginState, LoginEvent> {
    override fun reduce(
        state: LoginState,
        event: LoginEvent,
    ): LoginState =
        when (event) {
            is LoginEvent.EmailChangedEvent ->
                state.copy(
                    emailText = event.email,
                )

            is LoginEvent.ValidationEvent -> state
            is LoginEvent.ErrorEvent -> state
            is LoginEvent.LoginUserEvent ->
                state.copy(
                    pending = true,
                )

            is LoginEvent.PasswordChangedEvent ->
                state.copy(
                    passwordText = event.password,
                )

            is LoginEvent.UserHasLoggedEvent ->
                state.copy(
                    showUserHasLoggedDialog = true,
                    pending = false,
                )

            is LoginEvent.HideUserHasLoggedDialog ->
                state.copy(
                    showUserHasLoggedDialog = false,
                )

            is LoginEvent.HideUserErrorLoginDialog ->
                state.copy(
                    showUserErrorLoginDialog = false,
                )

            is LoginEvent.ShowUserErrorLoginDialog ->
                state.copy(
                    showUserErrorLoginDialog = true,
                    pending = false,
                )

            is LoginEvent.EmailPasswordValidationEmail ->
                state.copy(
                    emailLabelValid = event.emailValid,
                    passwordLabelValid = event.passwordValidation,
                    loginButtonEnabled = event.buttonEnabled,
                )

            is LoginEvent.ClearTextFields ->
                state.copy(
                    emailText = "",
                    passwordText = "",
                )
        }

    override fun createInitialState(): LoginState {
        return LoginState()
    }
}
