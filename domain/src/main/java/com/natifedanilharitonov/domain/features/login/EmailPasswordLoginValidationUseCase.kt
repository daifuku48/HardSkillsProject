package com.natifedanilharitonov.domain.features.login

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.Utils.EMAIL_PATTERN
import com.natifedanilharitonov.domain.Utils.PASSWORD_PATTERN
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult

class EmailPasswordLoginValidationUseCase : UseCase<LoginState, LoginEvent> {
    override suspend fun execute(
        state: LoginState,
        event: LoginEvent,
    ): LoginEvent {
        return if (event is LoginEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.emailText)
            val emailResult =
                if (emailValidation || state.emailText.isEmpty()) {
                    EmailValidationResult.ValidEmail
                } else {
                    EmailValidationResult.ErrorEmail
                }

            val passwordValidation = validatePassword(state.passwordText)
            val passwordResult =
                if (passwordValidation || state.passwordText.isEmpty()) {
                    PasswordValidationResult.ValidPassword
                } else {
                    PasswordValidationResult.ErrorPassword
                }
            val buttonEnabled = emailValidation && passwordValidation
            LoginEvent.EmailPasswordValidationEmail(
                emailValidation = emailResult,
                passwordValidation = passwordResult,
                buttonEnabled = buttonEnabled,
            )
        } else {
            LoginEvent.ErrorEvent
        }
    }

    private fun validateEmail(email: String): Boolean {
        return Regex(EMAIL_PATTERN).matches(email)
    }

    private fun validatePassword(password: String): Boolean {
        return Regex(PASSWORD_PATTERN).matches(password)
    }

    override fun canHandle(event: LoginEvent): Boolean {
        return event is LoginEvent.ValidationEvent
    }
}
