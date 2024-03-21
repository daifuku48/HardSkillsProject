package com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings_first

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.settings_first.SettingsFirstEvent
import com.natifedanilharitonov.hardskillsproject.presentation.settings_first.SettingsFirstState

class GetTextSettingsFirstUseCase(
    private val repository: MockTextRepository
): UseCase<SettingsFirstState, SettingsFirstEvent> {
    override suspend fun execute(
        state: SettingsFirstState,
        event: SettingsFirstEvent
    ): SettingsFirstEvent {
        return if (event is SettingsFirstEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                SettingsFirstEvent.TextIsReceived(StateText.Text(text))
            } else SettingsFirstEvent.TextIsReceived(StateText.ErrorText)
        } else SettingsFirstEvent.ErrorEvent
    }

    override fun canHandle(event: SettingsFirstEvent): Boolean {
        return event is SettingsFirstEvent.GetTextEvent
    }
}