package com.natifedanilharitonov.domain.mainActivity

import com.natifedanilharitonov.domain.features.mainActivity.GetStartDestinationUseCase
import com.natifedanilharitonov.domain.features.mainActivity.MainActivityEvent
import com.natifedanilharitonov.domain.features.mainActivity.MainActivityState
import com.natifedanilharitonov.domain.features.mainActivity.StartDestinationResult
import com.natifedanilharitonov.domain.model.DomainFirebaseUser
import com.natifedanilharitonov.domain.repository.FirebaseUserRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetStartDestinationUseCaseTest {
    private lateinit var useCase: GetStartDestinationUseCase

    @Mock
    private lateinit var repository: FirebaseUserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetStartDestinationUseCase(repository)
    }

    @Test
    fun `main screen destination`() =
        runTest {
            `when`(repository.getUser()).thenReturn(DomainFirebaseUser("mock@gmail.com"))
            val user = repository.getUser()
            val destination =
                if (user != null) StartDestinationResult.MainScreenDestination else StartDestinationResult.LoginScreenDestination
            val event =
                useCase.execute(MainActivityState(), MainActivityEvent.GetStartDestinationEvent)
            if (event is MainActivityEvent.StartDestinationIsReceivedEvent) {
                assertEquals(destination, event.startDestination)
            } else {
                assert(false)
            }
        }

    @Test
    fun `login screen destination`() =
        runTest {
            `when`(repository.getUser()).thenReturn(null)
            val user = repository.getUser()
            val destination =
                if (user != null) StartDestinationResult.MainScreenDestination else StartDestinationResult.LoginScreenDestination
            val event =
                useCase.execute(MainActivityState(), MainActivityEvent.GetStartDestinationEvent)
            if (event is MainActivityEvent.StartDestinationIsReceivedEvent) {
                assertEquals(destination, event.startDestination)
            } else {
                assert(false)
            }
        }

    @Test
    fun `wrong event`() =
        runTest {
            assert(!useCase.canHandle(MainActivityEvent.ErrorEvent))
            assert(!useCase.canHandle(MainActivityEvent.ChangeBottomStateEvent(false)))
            assert(!useCase.canHandle(MainActivityEvent.ChangeDrawerStateEvent(false)))
            assert(!useCase.canHandle(MainActivityEvent.SetSelectedNavigationBarItemEvent(1)))
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(MainActivityEvent.GetStartDestinationEvent))
        }
}
