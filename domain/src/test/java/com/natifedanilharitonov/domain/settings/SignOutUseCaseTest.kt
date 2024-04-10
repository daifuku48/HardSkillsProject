package com.natifedanilharitonov.domain.settings

import com.natifedanilharitonov.domain.features.settings.SettingsEvent
import com.natifedanilharitonov.domain.features.settings.SettingsState
import com.natifedanilharitonov.domain.features.settings.SignOutUseCase
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SignOutUseCaseTest {
    private lateinit var useCase: SignOutUseCase

    @Mock
    private lateinit var repository: FirebaseUserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = SignOutUseCase(repository)
    }

    @Test
    fun `sign out access`() =
        runTest {
            val event =
                useCase.execute(
                    SettingsState(),
                    SettingsEvent.SignOutUserEvent,
                )

            if (event is SettingsEvent.UserIsSignedOutEvent) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(SettingsEvent.SignOutUserEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(SettingsEvent.ErrorEvent))
            assert(!useCase.canHandle(SettingsEvent.UserIsSignedOutEvent))
        }
}
