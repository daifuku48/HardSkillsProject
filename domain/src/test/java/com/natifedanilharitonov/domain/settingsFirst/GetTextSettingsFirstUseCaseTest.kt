package com.natifedanilharitonov.domain.settingsFirst

import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.settingsFirst.GetTextSettingsFirstUseCase
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstEvent
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstState
import com.natifedanilharitonov.domain.repository.MockTextRepository
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
                    state = SettingsFirstState(text = StateText.Pending),
                    event = SettingsFirstEvent.GetTextEvent,
                )
            if (event is SettingsFirstEvent.TextIsReceived) {
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
                    state = SettingsFirstState(text = StateText.Pending),
                    event = SettingsFirstEvent.GetTextEvent,
                )
            if (event is SettingsFirstEvent.TextIsReceived) {
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
            assert(!useCase.canHandle(SettingsFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(SettingsFirstEvent.TextIsReceived(text = StateText.Pending)))
        }

    @Test
    fun `correct event test`() =
        runTest {
            assert(useCase.canHandle(SettingsFirstEvent.GetTextEvent))
        }
}
