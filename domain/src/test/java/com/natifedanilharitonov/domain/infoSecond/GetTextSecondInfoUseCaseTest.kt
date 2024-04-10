package com.natifedanilharitonov.domain.infoSecond

import com.natifedanilharitonov.domain.features.infoSecond.GetTextSecondInfoUseCase
import com.natifedanilharitonov.domain.features.infoSecond.InfoSecondEvent
import com.natifedanilharitonov.domain.features.infoSecond.InfoSecondState
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository
import junit.framework.TestCase
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetTextSecondInfoUseCaseTest {
    private lateinit var useCase: GetTextSecondInfoUseCase

    @Mock
    private lateinit var repository: MockTextRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetTextSecondInfoUseCase(repository)
    }

    @Test
    fun `execute get text access`() =
        runTest {
            Mockito.`when`(repository.getText()).thenReturn("text")
            val event =
                useCase.execute(
                    state = InfoSecondState(text = StateText.Pending),
                    event = InfoSecondEvent.GetTextEvent,
                )
            if (event is InfoSecondEvent.TextReceivedEvent) {
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
                    state = InfoSecondState(text = StateText.Pending),
                    event = InfoSecondEvent.GetTextEvent,
                )
            if (event is InfoSecondEvent.TextReceivedEvent) {
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
            assert(!useCase.canHandle(InfoSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(InfoSecondEvent.TextReceivedEvent(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(InfoSecondEvent.GetTextEvent))
        }
}
