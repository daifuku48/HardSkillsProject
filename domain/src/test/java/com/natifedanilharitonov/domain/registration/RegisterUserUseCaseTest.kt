package com.natifedanilharitonov.domain.registration

import com.natifedanilharitonov.domain.features.registration.RegisterUserUseCase
import com.natifedanilharitonov.domain.features.registration.RegistrationEvent
import com.natifedanilharitonov.domain.features.registration.RegistrationState
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RegisterUserUseCaseTest {
    private lateinit var useCase: RegisterUserUseCase

    @Mock
    private lateinit var repository: FirebaseUserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = RegisterUserUseCase(repository)
    }

    @Test
    fun `register access`() =
        runTest {
            val email = "mock@gmail.com"
            val password = "12345678"
            `when`(repository.register(email, password)).thenReturn(true)
            val event =
                useCase.execute(
                    RegistrationState(email = email, password = password),
                    RegistrationEvent.RegisterUserEvent,
                )
            if (event is RegistrationEvent.ShowUserHasLoggedDialog) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `register error`() =
        runTest {
            val email = "mock@gmail.com"
            val password = "123456789"
            `when`(repository.register(email, password)).thenReturn(false)
            val event =
                useCase.execute(
                    RegistrationState(email = email, password = password),
                    RegistrationEvent.RegisterUserEvent,
                )
            if (event is RegistrationEvent.HideUserErrorRegistrationDialog) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(RegistrationEvent.RegisterUserEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(RegistrationEvent.ValidationEvent))
            assert(!useCase.canHandle(RegistrationEvent.ErrorEvent))
            assert(!useCase.canHandle(RegistrationEvent.ShowUserHasLoggedDialog))
            assert(!useCase.canHandle(RegistrationEvent.NavigateToLoginUserEvent))
            assert(!useCase.canHandle(RegistrationEvent.HideUserHasRegisteredDialog))
        }
}
