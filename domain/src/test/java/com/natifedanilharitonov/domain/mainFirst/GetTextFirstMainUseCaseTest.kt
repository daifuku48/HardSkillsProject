package com.natifedanilharitonov.domain.mainFirst

import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.mainFirst.GetTextFirstMainUseCase
import com.natifedanilharitonov.domain.features.mainFirst.MainFirstEvent
import com.natifedanilharitonov.domain.features.mainFirst.MainFirstState
import com.natifedanilharitonov.domain.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTextFirstMainUseCaseTest {
    private lateinit var useCase: GetTextFirstMainUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextFirstMainUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = MainFirstState(text = StateText.Pending),
                    event = MainFirstEvent.GetMainTextEvent,
                )
            if (event is MainFirstEvent.MainTextIsReceived) {
                if (event.text is StateText.Text) {
                    TestCase.assertEquals(
                        "text",
                        (event.text as StateText.Text).text,
                    )
                } else {
                    assert(false)
                }
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
                    state = MainFirstState(text = StateText.Pending),
                    event = MainFirstEvent.GetMainTextEvent,
                )
            if (event is MainFirstEvent.MainTextIsReceived) {
                if (event.text is StateText.ErrorText) {
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
            assert(!useCase.canHandle(MainFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(MainFirstEvent.MainTextIsReceived(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(MainFirstEvent.GetMainTextEvent))
        }
}
