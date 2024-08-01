package info

import com.natifeuaandroid.domainmodule.features.info.InfoEvent
import com.natifeuaandroid.domainmodule.features.info.InfoState
import com.natifeuaandroid.domainmodule.features.info.useCases.GetUserInfoUseCase
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetUserInfoUseCaseTest {
    private lateinit var useCase: GetUserInfoUseCase

    @Mock
    private lateinit var repository: FirebaseUserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetUserInfoUseCase(repository)
    }

    @Test
    fun `execute get email access`() =
        runTest {
            `when`(repository.getUser()).thenReturn(mock())
            `when`(repository.getUser()?.email).thenReturn("mock@gmail.com")
            val event =
                useCase.execute(
                    state = InfoState(email = ""),
                    event = InfoEvent.GetUserInfoEvent,
                )
            if (event is InfoEvent.UserDataEventIsReceived) {
                if (event.email.isNotEmpty()) {
                    assertEquals(event.email, "mock@gmail.com")
                } else {
                    assert(false)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `execute get email error`() =
        runTest {
            `when`(repository.getUser()?.email).thenReturn(null)
            val event =
                useCase.execute(
                    state = InfoState(email = "null"),
                    event = InfoEvent.GetUserInfoEvent,
                )
            if (event is InfoEvent.EmailErrorEvent) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `wrong event test`() =
        runTest {
            assert(!useCase.canHandle(InfoEvent.ErrorEvent))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(InfoEvent.GetUserInfoEvent))
        }
}
