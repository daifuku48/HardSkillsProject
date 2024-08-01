package main

import com.natifeuaandroid.domainmodule.features.main.MainEvent
import com.natifeuaandroid.domainmodule.features.main.MainState
import com.natifeuaandroid.domainmodule.features.main.useCases.GetMainTextUseCase
import com.natifeuaandroid.domainmodule.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetMainTextUseCaseTest {
    private lateinit var useCase: GetMainTextUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetMainTextUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = MainState(text = ""),
                    event = MainEvent.GetMainTextEvent,
                )
            if (event is MainEvent.MainTextIsReceived) {
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
                    state = MainState(text = ""),
                    event = MainEvent.GetMainTextEvent,
                )
            if (event is MainEvent.MainTextIsReceived) {
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
            assert(!useCase.canHandle(MainEvent.ErrorEvent))
            assert(!useCase.canHandle(MainEvent.MainTextIsReceived(text = "")))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(MainEvent.GetMainTextEvent))
        }
}
