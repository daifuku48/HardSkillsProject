package com.natifedanilharitonov.domain.use_cases.settings_second

import com.natifedanilharitonov.domain.repository.MockTextRepository
import com.natifedanilharitonov.domain.use_cases.main.StateText

class GetTextSettingsSecondUseCase(
    private val repository: MockTextRepository
) : com.natifedanilharitonov.core.UseCase<SettingsSecondState, SettingsSecondEvent> {
    override suspend fun execute(
        state: SettingsSecondState,
        event: SettingsSecondEvent
    ): SettingsSecondEvent {
        return if (event is SettingsSecondEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                SettingsSecondEvent.TextIsReceived(StateText.Text(text))
            } else SettingsSecondEvent.TextIsReceived(StateText.ErrorText)
        } else SettingsSecondEvent.ErrorEvent
    }

    override fun canHandle(event: SettingsSecondEvent): Boolean {
        return event is SettingsSecondEvent.GetTextEvent
    }
}