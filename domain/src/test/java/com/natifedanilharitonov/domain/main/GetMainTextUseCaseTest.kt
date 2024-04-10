package com.natifedanilharitonov.domain.main

import com.natifedanilharitonov.domain.features.main.GetMainTextUseCase
import com.natifedanilharitonov.domain.features.main.MainEvent
import com.natifedanilharitonov.domain.features.main.MainState
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository
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
                    state = MainState(text = StateText.Pending),
                    event = MainEvent.GetMainTextEvent,
                )
            if (event is MainEvent.MainTextIsReceived) {
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
                    state = MainState(text = StateText.Pending),
                    event = MainEvent.GetMainTextEvent,
                )
            if (event is MainEvent.MainTextIsReceived) {
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
            assert(!useCase.canHandle(MainEvent.ErrorEvent))
            assert(!useCase.canHandle(MainEvent.MainTextIsReceived(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(MainEvent.GetMainTextEvent))
        }
}
