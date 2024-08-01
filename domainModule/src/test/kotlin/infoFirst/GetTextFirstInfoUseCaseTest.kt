package infoFirst


import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstEvent
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstState
import com.natifeuaandroid.domainmodule.features.infoFirst.useCases.GetTextFirstInfoUseCase
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetTextFirstInfoUseCaseTest {
    private lateinit var useCase: GetTextFirstInfoUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextFirstInfoUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            `when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = InfoFirstState(text = ""),
                    event = InfoFirstEvent.GetTextEvent,
                )
            if (event is InfoFirstEvent.TextReceivedEvent) {
                assertEquals(
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
            `when`(repository.getText()).thenReturn(null)
            val event =
                useCase.execute(
                    state = InfoFirstState(text = ""),
                    event = InfoFirstEvent.GetTextEvent,
                )
            if (event is InfoFirstEvent.TextReceivedEvent) {
                if (event.text == null) {
                    assert(true)
                } else {
                    assert(false)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `wrong event test`() =
        runTest {
            assert(!useCase.canHandle(InfoFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(InfoFirstEvent.TextReceivedEvent(text = "")))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(InfoFirstEvent.GetTextEvent))
        }
}
