package com.natifedanilharitonov.domain.features.registration

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.Utils
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult

class EmailPasswordValidationRegistrationUseCase : UseCase<RegistrationState, RegistrationEvent> {
    override suspend fun execute(
        state: RegistrationState,
        event: RegistrationEvent,
    ): RegistrationEvent {
        return if (event is RegistrationEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.email)
            val emailResult =
                if (emailValidation || state.email.isEmpty()) {
                    EmailValidationResult.ValidEmail
                } else {
                    EmailValidationResult.ErrorEmail
                }
            val passwordValidation = validatePassword(state.password)
            val passwordResult =
                if (passwordValidation || state.password.isEmpty()) {
                    PasswordValidationResult.ValidPassword
                } else {
                    PasswordValidationResult.ErrorPassword
                }
            val buttonEnabled = emailValidation && passwordValidation
            RegistrationEvent.EmailPasswordValidationLabelReceived(
                labelEmail = emailResult,
                labelPassword = passwordResult,
                buttonEnabled = buttonEnabled,
            )
        } else {
            RegistrationEvent.ErrorEvent
        }
    }

    private fun validateEmail(email: String): Boolean {
        return Regex(Utils.EMAIL_PATTERN).matches(email)
    }

    private fun validatePassword(password: String): Boolean {
        return Regex(Utils.PASSWORD_PATTERN).matches(password)
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.ValidationEvent
    }
}
