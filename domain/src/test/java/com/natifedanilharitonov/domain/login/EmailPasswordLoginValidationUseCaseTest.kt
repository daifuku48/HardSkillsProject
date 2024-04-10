package com.natifedanilharitonov.domain.login

import com.natifedanilharitonov.domain.Utils
import com.natifedanilharitonov.domain.features.login.EmailPasswordLoginValidationUseCase
import com.natifedanilharitonov.domain.features.login.LoginEvent
import com.natifedanilharitonov.domain.features.login.LoginState
import com.natifedanilharitonov.domain.features.login.model.EmailValidationResult
import com.natifedanilharitonov.domain.features.login.model.PasswordValidationResult
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class EmailPasswordLoginValidationUseCaseTest {
    private val useCase = EmailPasswordLoginValidationUseCase()

    @Test
    fun `correct password and email`() =
        runTest {
            val emailText = "mock@gmail.com"
            val passwordText = "12345678"
            val event =
                useCase.execute(
                    LoginState(
                        emailText = emailText,
                        passwordText = passwordText,
                    ),
                    LoginEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

            val emailResult =
                if (emailValidation) EmailValidationResult.ValidEmail else EmailValidationResult.ErrorEmail
            val passwordResult =
                if (passwordValidation) PasswordValidationResult.ValidPassword else PasswordValidationResult.ErrorPassword

            val buttonEnabled = emailValidation && passwordValidation
            if (event is LoginEvent.EmailPasswordValidationEmail) {
                assertEquals(emailResult, event.emailValidation)
                assertEquals(passwordResult, event.passwordValidation)
                assertEquals(buttonEnabled, event.buttonEnabled)
            } else {
                assert(false)
            }
        }

    @Test
    fun `incorrect password and correct email`() =
        runTest {
            val emailText = "mock@gmail.com"
            val passwordText = "1234567"
            val event =
                useCase.execute(
                    LoginState(
                        emailText = emailText,
                        passwordText = passwordText,
                    ),
                    LoginEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

            val emailResult =
                if (emailValidation) EmailValidationResult.ValidEmail else EmailValidationResult.ErrorEmail
            val passwordResult =
                if (passwordValidation) PasswordValidationResult.ValidPassword else PasswordValidationResult.ErrorPassword

            val buttonEnabled = emailValidation && passwordValidation
            if (event is LoginEvent.EmailPasswordValidationEmail) {
                assertEquals(emailResult, event.emailValidation)
                assertEquals(passwordResult, event.passwordValidation)
                assertEquals(buttonEnabled, event.buttonEnabled)
            } else {
                assert(false)
            }
        }

    @Test
    fun `incorrect email and correct password`() =
        runTest {
            val emailText = "mockgmail.com"
            val passwordText = "12345673"
            val event =
                useCase.execute(
                    LoginState(
                        emailText = emailText,
                        passwordText = passwordText,
                    ),
                    LoginEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

            val emailResult =
                if (emailValidation) EmailValidationResult.ValidEmail else EmailValidationResult.ErrorEmail
            val passwordResult =
                if (passwordValidation) PasswordValidationResult.ValidPassword else PasswordValidationResult.ErrorPassword

            val buttonEnabled = emailValidation && passwordValidation
            if (event is LoginEvent.EmailPasswordValidationEmail) {
                assertEquals(emailResult, event.emailValidation)
                assertEquals(passwordResult, event.passwordValidation)
                assertEquals(buttonEnabled, event.buttonEnabled)
            } else {
                assert(false)
            }
        }

    @Test
    fun `incorrect email and password`() =
        runTest {
            val emailText = "mockgmail.com"
            val passwordText = "12343"
            val event =
                useCase.execute(
                    LoginState(
                        emailText = emailText,
                        passwordText = passwordText,
                    ),
                    LoginEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

            val emailResult =
                if (emailValidation) EmailValidationResult.ValidEmail else EmailValidationResult.ErrorEmail
            val passwordResult =
                if (passwordValidation) PasswordValidationResult.ValidPassword else PasswordValidationResult.ErrorPassword

            val buttonEnabled = emailValidation && passwordValidation
            if (event is LoginEvent.EmailPasswordValidationEmail) {
                assertEquals(emailResult, event.emailValidation)
                assertEquals(passwordResult, event.passwordValidation)
                assertEquals(buttonEnabled, event.buttonEnabled)
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(LoginEvent.ValidationEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(LoginEvent.LoginUserEvent))
            assert(!useCase.canHandle(LoginEvent.ErrorEvent))
            assert(!useCase.canHandle(LoginEvent.UserHasLoggedEvent))
            assert(!useCase.canHandle(LoginEvent.ClearTextFields))
            assert(!useCase.canHandle(LoginEvent.HideUserErrorLoginDialog))
        }
}
