package com.natifedanilharitonov.hardskillsproject.domain.login

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils.PASSWORD_PATTERN
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginEvent
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginState

class PasswordValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<LoginState, LoginEvent> {
    override fun execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.PasswordValidationEvent) {
            if (state.password.isEmpty()) {
                LoginEvent.PasswordValidationLabelReceived(
                    resourcesRepository.getPasswordLabel(),
                    Color.Black
                )
            } else
                if (validatePassword(state.password)) {
                    LoginEvent.PasswordValidationLabelReceived(
                        resourcesRepository.getPasswordLabel(),
                        Color.Black
                    )
                } else {
                    LoginEvent.PasswordValidationLabelReceived(
                        resourcesRepository.getPasswordErrorLabel(),
                        Color.Red
                    )
                }
        } else LoginEvent.ErrorEvent
    }

    private fun validatePassword(password: String): Boolean {
        return Regex(PASSWORD_PATTERN).matches(password)
    }

    override fun canHandle(event: LoginEvent): Boolean {
        return event is LoginEvent.PasswordValidationEvent
    }
}