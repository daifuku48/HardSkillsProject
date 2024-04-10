package com.natifedanilharitonov.domain.settingsSecond

import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.settingsSecond.GetTextSettingsSecondUseCase
import com.natifedanilharitonov.domain.features.settingsSecond.SettingsSecondEvent
import com.natifedanilharitonov.domain.features.settingsSecond.SettingsSecondState
import com.natifedanilharitonov.domain.repository.MockTextRepository
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
                    state = SettingsSecondState(text = StateText.Pending),
                    event = SettingsSecondEvent.GetTextEvent,
                )
            if (event is SettingsSecondEvent.TextIsReceived) {
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
                    state = SettingsSecondState(text = StateText.Pending),
                    event = SettingsSecondEvent.GetTextEvent,
                )
            if (event is SettingsSecondEvent.TextIsReceived) {
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
            assert(!useCase.canHandle(SettingsSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(SettingsSecondEvent.TextIsReceived(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(SettingsSecondEvent.GetTextEvent))
        }
}
