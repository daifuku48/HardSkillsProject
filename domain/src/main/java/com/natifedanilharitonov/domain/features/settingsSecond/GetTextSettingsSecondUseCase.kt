package com.natifedanilharitonov.domain.features.settingsSecond

import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextSettingsSecondUseCase(
    private val repository: MockTextRepository,
) : com.natifedanilharitonov.core.UseCase<SettingsSecondState, SettingsSecondEvent> {
    override suspend fun execute(
        state: SettingsSecondState,
        event: SettingsSecondEvent,
    ): SettingsSecondEvent {
        return if (event is SettingsSecondEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                SettingsSecondEvent.TextIsReceived(StateText.Text(text))
            } else {
                SettingsSecondEvent.TextIsReceived(StateText.ErrorText)
            }
        } else {
            SettingsSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: SettingsSecondEvent): Boolean {
        return event is SettingsSecondEvent.GetTextEvent
    }
}
