package com.natifedanilharitonov.hardskillsproject.domain.login

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils.EMAIL_PATTERN
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginEvent
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginState

class EmailValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<LoginState, LoginEvent> {
    override fun execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.EmailValidationEvent) {
            if (state.email.isEmpty()) {
                LoginEvent.EmailValidationLabelReceived(
                    resourcesRepository.getEmailLabel(),
                    Color.Black
                )
            } else
                if (validateEmail(state.email)) {
                    LoginEvent.EmailValidationLabelReceived(
                        resourcesRepository.getEmailLabel(),
                        Color.Black
                    )
                } else {
                    LoginEvent.EmailValidationLabelReceived(
                        resourcesRepository.getEmailErrorLabel(),
                        Color.Red
                    )
                }
        } else LoginEvent.ErrorEvent
    }

    private fun validateEmail(email: String): Boolean {
        return Regex(EMAIL_PATTERN).matches(email)
    }

    override fun canHandle(event: LoginEvent): Boolean {
        return event is LoginEvent.EmailValidationEvent
    }
}