package settings

import com.natifeuaandroid.domainmodule.features.settings.SettingsEvent
import com.natifeuaandroid.domainmodule.features.settings.SettingsState
import com.natifeuaandroid.domainmodule.features.settings.useCases.SignOutUseCase
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository
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
