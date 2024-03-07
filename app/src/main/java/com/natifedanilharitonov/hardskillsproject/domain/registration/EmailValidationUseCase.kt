package com.natifedanilharitonov.hardskillsproject.domain.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationEvent
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationState

class EmailValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<RegistrationState, RegistrationEvent> {
    override fun execute(state: RegistrationState, event: RegistrationEvent): RegistrationEvent {
        return if (event is RegistrationEvent.EmailValidationEvent) {
            if (state.email.isEmpty()) {
                RegistrationEvent.EmailValidationLabelReceived(
                    resourcesRepository.getEmailLabel(),
                    Color.Black
                )
            } else
                if (validateEmail(state.email)) {
                    RegistrationEvent.EmailValidationLabelReceived(
                        resourcesRepository.getEmailLabel(),
                        Color.Black
                    )
                } else {
                    RegistrationEvent.EmailValidationLabelReceived(
                        resourcesRepository.getEmailErrorLabel(),
                        Color.Red
                    )
                }
        } else RegistrationEvent.ErrorEvent
    }

    private fun validateEmail(email: String): Boolean {
        return Regex(Utils.EMAIL_PATTERN).matches(email)
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.EmailValidationEvent
    }
}