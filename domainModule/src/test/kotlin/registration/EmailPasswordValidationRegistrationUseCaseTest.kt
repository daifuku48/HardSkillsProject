package registration

import com.natifeuaandroid.domainmodule.Utils
import com.natifeuaandroid.domainmodule.features.registration.RegistrationEvent
import com.natifeuaandroid.domainmodule.features.registration.RegistrationState
import com.natifeuaandroid.domainmodule.features.registration.useCases.EmailPasswordValidationRegistrationUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class EmailPasswordValidationRegistrationUseCaseTest {
    private val useCase: EmailPasswordValidationRegistrationUseCase =
        EmailPasswordValidationRegistrationUseCase()

    @Test
    fun `correct password and email`() =
        runTest {
            val emailText = "mock@gmail.com"
            val passwordText = "12345678"
            val event =
                useCase.execute(
                    RegistrationState(
                        email = emailText,
                        password = passwordText,
                    ),
                    RegistrationEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

            val buttonEnabled = emailValidation && passwordValidation
            if (event is RegistrationEvent.EmailPasswordValidationLabelReceived) {
                assertEquals(emailValidation, event.labelEmail)
                assertEquals(passwordValidation, event.labelPassword)
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
                    RegistrationState(
                        email = emailText,
                        password = passwordText,
                    ),
                    RegistrationEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()


            val buttonEnabled = emailValidation && passwordValidation
            if (event is RegistrationEvent.EmailPasswordValidationLabelReceived) {
                assertEquals(emailValidation, event.labelEmail)
                assertEquals(passwordValidation, event.labelPassword)
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
                    RegistrationState(
                        email = emailText,
                        password = passwordText,
                    ),
                    RegistrationEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()


            val buttonEnabled = emailValidation && passwordValidation
            if (event is RegistrationEvent.EmailPasswordValidationLabelReceived) {
                assertEquals(emailValidation, event.labelEmail)
                assertEquals(passwordValidation, event.labelPassword)
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
                    RegistrationState(
                        email = emailText,
                        password = passwordText,
                    ),
                    RegistrationEvent.ValidationEvent,
                )

            val emailValidation =
                Regex(Utils.EMAIL_PATTERN).matches(emailText) || emailText.isEmpty()
            val passwordValidation =
                Regex(Utils.PASSWORD_PATTERN).matches(passwordText) || passwordText.isEmpty()

              val buttonEnabled = emailValidation && passwordValidation
            if (event is RegistrationEvent.EmailPasswordValidationLabelReceived) {
                assertEquals(emailValidation, event.labelEmail)
                assertEquals(passwordValidation, event.labelPassword)
                assertEquals(buttonEnabled, event.buttonEnabled)
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(RegistrationEvent.ValidationEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(RegistrationEvent.RegisterUserEvent))
            assert(!useCase.canHandle(RegistrationEvent.ErrorEvent))
            assert(!useCase.canHandle(RegistrationEvent.NavigateToLoginUserEvent))
            assert(!useCase.canHandle(RegistrationEvent.HideUserErrorRegistrationDialog))
            assert(!useCase.canHandle(RegistrationEvent.ShowUserHasLoggedDialog))
        }
}
