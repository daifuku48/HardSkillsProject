package com.natifedanilharitonov.domain.mainSecond

import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.mainSecond.GetTextSecondMainUseCase
import com.natifedanilharitonov.domain.features.mainSecond.MainSecondEvent
import com.natifedanilharitonov.domain.features.mainSecond.MainSecondState
import com.natifedanilharitonov.domain.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTextSecondMainUseCaseTest {
    private lateinit var useCase: GetTextSecondMainUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextSecondMainUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = MainSecondState(text = StateText.Pending),
                    event = MainSecondEvent.GetMainTextEvent,
                )
            if (event is MainSecondEvent.MainTextIsReceived) {
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
                    state = MainSecondState(text = StateText.Pending),
                    event = MainSecondEvent.GetMainTextEvent,
                )
            if (event is MainSecondEvent.MainTextIsReceived) {
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
            assert(!useCase.canHandle(MainSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(MainSecondEvent.MainTextIsReceived(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(MainSecondEvent.GetMainTextEvent))
        }
}
