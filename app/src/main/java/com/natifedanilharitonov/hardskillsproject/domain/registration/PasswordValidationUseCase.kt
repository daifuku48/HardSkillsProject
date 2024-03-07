package com.natifedanilharitonov.hardskillsproject.domain.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationEvent
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationState

class PasswordValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<RegistrationState, RegistrationEvent> {
    override fun execute(state: RegistrationState, event: RegistrationEvent): RegistrationEvent {
        return if (event is RegistrationEvent.PasswordValidationEvent) {
            if (state.password.isEmpty()) {
                RegistrationEvent.PasswordValidationLabelReceived(
                    resourcesRepository.getPasswordLabel(),
                    Color.Black
                )
            } else
                if (validatePassword(state.password)) {
                    RegistrationEvent.PasswordValidationLabelReceived(
                        resourcesRepository.getPasswordLabel(),
                        Color.Black
                    )
                } else {
                    RegistrationEvent.PasswordValidationLabelReceived(
                        resourcesRepository.getPasswordErrorLabel(),
                        Color.Red
                    )
                }
        } else RegistrationEvent.ErrorEvent
    }

    private fun validatePassword(password: String): Boolean {
        return Regex(Utils.PASSWORD_PATTERN).matches(password)
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.PasswordValidationEvent
    }
}