package com.natifedanilharitonov.hardskillsproject.domain.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationEvent
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationState

class EmailPasswordValidationRegistrationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<RegistrationState, RegistrationEvent> {
    override suspend fun execute(
        state: RegistrationState,
        event: RegistrationEvent
    ): RegistrationEvent {
        return if (event is RegistrationEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.email)
            val emailLabel =
                if (emailValidation || state.email.isEmpty()) resourcesRepository.getEmailLabel() else resourcesRepository.getEmailErrorLabel()
            val emailColor =
                if (emailValidation || state.email.isEmpty()) Color.Black else Color.Red
            val passwordValidation = validatePassword(state.password)
            val passwordLabel =
                if (passwordValidation || state.password.isEmpty()) resourcesRepository.getPasswordLabel() else resourcesRepository.getPasswordErrorLabel()
            val passwordColor =
                if (passwordValidation || state.password.isEmpty()) Color.Black else Color.Red
            val buttonEnabled = emailValidation && passwordValidation
            RegistrationEvent.EmailPasswordValidationLabelReceived(
                labelEmail = emailLabel,
                labelPassword = passwordLabel,
                colorLabelEmail = emailColor,
                colorLabelPassword = passwordColor,
                buttonEnabled = buttonEnabled
            )
        } else RegistrationEvent.ErrorEvent
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