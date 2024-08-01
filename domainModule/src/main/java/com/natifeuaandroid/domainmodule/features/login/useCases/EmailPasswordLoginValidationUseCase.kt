package com.natifeuaandroid.domainmodule.features.login.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.Utils.EMAIL_PATTERN
import com.natifeuaandroid.domainmodule.Utils.PASSWORD_PATTERN
import com.natifeuaandroid.domainmodule.features.login.LoginEvent
import com.natifeuaandroid.domainmodule.features.login.LoginState


class EmailPasswordLoginValidationUseCase : UseCase<LoginState, LoginEvent> {
    override suspend fun execute(
        state: LoginState,
        event: LoginEvent,
    ): LoginEvent {
        return if (event is LoginEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.emailText)
            val emailResult =emailValidation || state.emailText.isEmpty()
            val passwordValidation = validatePassword(state.passwordText)
            val passwordResult =passwordValidation || state.passwordText.isEmpty()
            val buttonEnabled = emailValidation && passwordValidation
            LoginEvent.EmailPasswordValidationEmail(
                emailValid = emailResult,
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
