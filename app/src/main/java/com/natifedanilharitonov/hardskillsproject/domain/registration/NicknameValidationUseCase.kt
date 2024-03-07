package com.natifedanilharitonov.hardskillsproject.domain.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils.NICKNAME_PATTERN
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationEvent
import com.natifedanilharitonov.hardskillsproject.presentation.registration.RegistrationState

class NicknameValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<RegistrationState, RegistrationEvent> {
    override fun execute(state: RegistrationState, event: RegistrationEvent): RegistrationEvent {
        return if (event is RegistrationEvent.NicknameValidationEvent) {
            if (state.nickname.isEmpty()) {
                RegistrationEvent.NicknameValidationLabelReceived(
                    label = resourcesRepository.getNicknameLabel(),
                    color = Color.Black
                )
            } else if (validateNickname(state.nickname)) {
                RegistrationEvent.NicknameValidationLabelReceived(
                    label = resourcesRepository.getNicknameLabel(),
                    color = Color.Black
                )
            } else {
                RegistrationEvent.NicknameValidationLabelReceived(
                    label = resourcesRepository.getNicknameErrorLabel(),
                    color = Color.Red
                )
            }
        } else RegistrationEvent.ErrorEvent
    }

    private fun validateNickname(nickname: String): Boolean {
        return Regex(NICKNAME_PATTERN).matches(nickname)
    }

    override fun canHandle(event: RegistrationEvent): Boolean {
        return event is RegistrationEvent.NicknameValidationEvent
    }
}