package login

import com.natifeuaandroid.domainmodule.features.login.LoginEvent
import com.natifeuaandroid.domainmodule.features.login.LoginState
import com.natifeuaandroid.domainmodule.features.login.useCases.LoginUserUseCase
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LoginUserUseCaseTest {
    private lateinit var useCase: LoginUserUseCase

    @Mock
    private lateinit var repository: FirebaseUserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = LoginUserUseCase(repository)
    }

    @Test
    fun `login access`() =
        runTest {
            val email = "mock@gmail.com"
            val password = "12345678"
            `when`(repository.login(email, password)).thenReturn(true)
            val event =
                useCase.execute(
                    LoginState(emailText = email, passwordText = password),
                    LoginEvent.LoginUserEvent,
                )

            if (event is LoginEvent.UserHasLoggedEvent) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `login error`() =
        runTest {
            val email = "mock@gmail.com"
            val password = "123456789"
            `when`(repository.login(email, password)).thenReturn(false)
            val event =
                useCase.execute(
                    LoginState(emailText = email, passwordText = password),
                    LoginEvent.LoginUserEvent,
                )

            if (event is LoginEvent.UserHasLoggedEvent) {
                assert(false)
            } else {
                assert(true)
            }
        }

    @Test
    fun `wrong event`() =
        runTest {
            assert(!useCase.canHandle(LoginEvent.UserHasLoggedEvent))
            assert(!useCase.canHandle(LoginEvent.ValidationEvent))
            assert(!useCase.canHandle(LoginEvent.HideUserErrorLoginDialog))
            assert(!useCase.canHandle(LoginEvent.ClearTextFields))
            assert(!useCase.canHandle(LoginEvent.ShowUserErrorLoginDialog))
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(LoginEvent.LoginUserEvent))
        }
}
