package com.natifeuaandroid.domainmodule.features.settingsSecond.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondEvent
import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetTextSettingsSecondUseCase(
    private val repository: MockTextRepository,
) : UseCase<SettingsSecondState, SettingsSecondEvent> {
    override suspend fun execute(
        state: SettingsSecondState,
        event: SettingsSecondEvent,
    ): SettingsSecondEvent {
        return if (event is SettingsSecondEvent.GetTextEvent) {
            val text = repository.getText()
            SettingsSecondEvent.TextIsReceived(text)
        } else {
            SettingsSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: SettingsSecondEvent): Boolean {
        return event is SettingsSecondEvent.GetTextEvent
    }
}
