package com.natifedanilharitonov.hardskillsproject.presentation.registration

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.use_cases.login.model.PasswordValidationResult
import com.natifedanilharitonov.domain.use_cases.registration.RegistrationEvent
import com.natifedanilharitonov.domain.use_cases.registration.RegistrationState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

class RegistrationReducer(
    private val emailLabelMapper: EmailValidationResult.Mapper<EmailLabelState>,
    private val passwordLabelMapper: PasswordValidationResult.Mapper<PasswordLabelState>
) : Reducer<RegistrationState, RegistrationEvent, RegistrationUiState> {
    override fun reduce(state: RegistrationState, event: RegistrationEvent): RegistrationState {
        return when (event) {
            is RegistrationEvent.EmailChangedEvent -> state.copy(email = event.email)
            RegistrationEvent.ValidationEvent -> state
            is RegistrationEvent.EmailPasswordValidationLabelReceived -> state.copy(
                emailLabel = event.labelEmail,
                passwordLabel = event.labelPassword,
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

    override fun mapToUiModel(state: RegistrationState): RegistrationUiState {
        return RegistrationUiState(
            email = state.email,
            password = state.password,
            emailLabel = state.emailLabel.map(emailLabelMapper),
            passwordLabel = state.passwordLabel.map(passwordLabelMapper),
            pending = state.pending,
            registerButtonEnabled = state.registerButtonEnabled,
            showUserHasLoggedDialog = state.showUserHasLoggedDialog,
            showUserErrorRegisterDialog = state.showUserErrorRegisterDialog
        )
    }
}