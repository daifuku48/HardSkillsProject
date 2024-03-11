package com.natifedanilharitonov.hardskillsproject.domain.login

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.ResourcesRepository
import com.natifedanilharitonov.hardskillsproject.domain.Utils.EMAIL_PATTERN
import com.natifedanilharitonov.hardskillsproject.domain.Utils.PASSWORD_PATTERN
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginEvent
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginState

class EmailPasswordLoginValidationUseCase(
    private val resourcesRepository: ResourcesRepository
) : UseCase<LoginState, LoginEvent> {
    override suspend fun execute(state: LoginState, event: LoginEvent): LoginEvent {
        return if (event is LoginEvent.ValidationEvent) {
            val emailValidation = validateEmail(state.email)
            val emailLabel =
                if (emailValidation || state.email.isEmpty()) resourcesRepository.getEmailLabel() else resourcesRepository.getEmailErrorLabel()
            val emailColor =
                if (emailValidation || state.password.isEmpty()) Color.Black else Color.Red
            val passwordValidation = validatePassword(state.password)
            val passwordLabel =
                if (passwordValidation || state.password.isEmpty()) resourcesRepository.getPasswordLabel() else resourcesRepository.getPasswordErrorLabel()
            val passwordColor =
                if (passwordValidation || state.password.isEmpty()) Color.Black else Color.Red
            val buttonEnabled = emailValidation && passwordValidation
            LoginEvent.EmailPasswordValidationEmail(
                labelEmail = emailLabel,
                labelPassword = passwordLabel,
                colorLabelEmail = emailColor,
                colorLabelPassword = passwordColor,
                buttonEnabled = buttonEnabled
            )
        } else LoginEvent.ErrorEvent
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