package settingsSecond

import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondEvent
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondState
import com.natifeuaandroid.domainmodule.features.settingsSecond.useCases.GetTextSettingsSecondUseCase
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTextSettingsSecondUseCaseTest {
    private lateinit var useCase: GetTextSettingsSecondUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextSettingsSecondUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = SettingsSecondState(text = ""),
                    event = SettingsSecondEvent.GetTextEvent,
                )
            if (event is SettingsSecondEvent.TextIsReceived) {
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
                    state = SettingsSecondState(text = ""),
                    event = SettingsSecondEvent.GetTextEvent,
                )
            if (event is SettingsSecondEvent.TextIsReceived) {
                assert(true)
            } else {
                assert(false)
            }
        }

    @Test
    fun `wrong event test`() =
        runTest {
            assert(!useCase.canHandle(SettingsSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(SettingsSecondEvent.TextIsReceived(text = "")))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(SettingsSecondEvent.GetTextEvent))
        }
}
