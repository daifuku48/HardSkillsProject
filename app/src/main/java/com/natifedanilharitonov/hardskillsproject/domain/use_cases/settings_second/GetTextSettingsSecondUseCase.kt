package com.natifedanilharitonov.hardskillsproject.domain.use_cases.settings_second

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.settings_second.SettingsSecondEvent
import com.natifedanilharitonov.hardskillsproject.presentation.settings_second.SettingsSecondState

class GetTextSettingsSecondUseCase(
    private val repository: MockTextRepository
) : UseCase<SettingsSecondState, SettingsSecondEvent> {
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