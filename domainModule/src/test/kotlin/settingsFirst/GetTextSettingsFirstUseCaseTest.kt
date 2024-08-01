package settingsFirst

import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstEvent
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstState
import com.natifeuaandroid.domainmodule.features.settingsFirst.useCases.GetTextSettingsFirstUseCase
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTextSettingsFirstUseCaseTest {
    private lateinit var useCase: GetTextSettingsFirstUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextSettingsFirstUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = SettingsFirstState(text = ""),
                    event = SettingsFirstEvent.GetTextEvent,
                )
            if (event is SettingsFirstEvent.TextIsReceived) {
                TestCase.assertEquals(
                    "text",
                    event.text,
                )
            } else {
                assert(false)
            }
        }

    @Test
    fun `execute get text error`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn(null)
            val event =
                useCase.execute(
                    state = SettingsFirstState(text = ""),
                    event = SettingsFirstEvent.GetTextEvent,
                )
            if (event is SettingsFirstEvent.TextIsReceived) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `wrong event test`() =
        runTest {
            assert(!useCase.canHandle(SettingsFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(SettingsFirstEvent.TextIsReceived(text = "")))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(SettingsFirstEvent.GetTextEvent))
        }
}
