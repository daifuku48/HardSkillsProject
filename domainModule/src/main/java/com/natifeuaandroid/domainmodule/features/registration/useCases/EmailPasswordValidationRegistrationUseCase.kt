package com.natifeuaandroid.domainmodule.features.registration.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.Utils
import com.natifeuaandroid.domainmodule.features.registration.RegistrationEvent
import com.natifeuaandroid.domainmodule.features.registration.RegistrationState


class EmailPasswordValidationRegistrationUseCase : UseCase<RegistrationState, RegistrationEvent> {
    override suspend fun execute(
        state: RegistrationState,
        event: RegistrationEvent,
    ): RegistrationEvent {
        return if (event is RegistrationEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.email)
            val emailResult = (emailValidation || state.email.isEmpty())
            val passwordValidation = validatePassword(state.password)
            val passwordResult = (passwordValidation || state.password.isEmpty())
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
