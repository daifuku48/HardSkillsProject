package com.natifedanilharitonov.hardskillsproject.presentation.login

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.login.LoginEvent
import com.natifedanilharitonov.domain.features.login.LoginState
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

class LoginReducer(
    private val emailLabelMapper: EmailValidationResult.Mapper<EmailLabelState>,
    private val passwordLabelMapper: PasswordValidationResult.Mapper<PasswordLabelState>,
) : Reducer<LoginState, LoginEvent, LoginUiState> {
    override fun reduce(
        state: LoginState,
        event: LoginEvent,
    ): LoginState {
        return when (event) {
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
                    emailState = event.emailValidation,
                    passwordState = event.passwordValidation,
                    loginButtonEnabled = event.buttonEnabled,
                )

            is LoginEvent.ClearTextFields ->
                state.copy(
                    emailText = "",
                    passwordText = "",
                )
        }
    }

    override fun mapToUiModel(state: LoginState): LoginUiState {
        return LoginUiState(
            email = state.emailText,
            password = state.passwordText,
            emailLabel = state.emailState.map(emailLabelMapper),
            passwordLabel = state.passwordState.map(passwordLabelMapper),
            pending = state.pending,
            showUserHasLoggedDialog = state.showUserHasLoggedDialog,
            showUserErrorLoginDialog = state.showUserErrorLoginDialog,
            loginButtonEnabled = state.loginButtonEnabled,
        )
    }
}
