package com.natifeuaandroid.domainmodule.features.settingsFirst.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstEvent
import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetTextSettingsFirstUseCase(
    private val repository: MockTextRepository,
) : UseCase<SettingsFirstState, SettingsFirstEvent> {
    override suspend fun execute(
        state: SettingsFirstState,
        event: SettingsFirstEvent,
    ): SettingsFirstEvent {
        return if (event is SettingsFirstEvent.GetTextEvent) {
            val text = repository.getText()
            SettingsFirstEvent.TextIsReceived(text)
        } else {
            SettingsFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: SettingsFirstEvent): Boolean {
        return event is SettingsFirstEvent.GetTextEvent
    }
}
