package com.natifedanilharitonov.domain.features.settingsFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextSettingsFirstUseCase(
    private val repository: MockTextRepository,
) : UseCase<SettingsFirstState, SettingsFirstEvent> {
    override suspend fun execute(
        state: SettingsFirstState,
        event: SettingsFirstEvent,
    ): SettingsFirstEvent {
        return if (event is SettingsFirstEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                SettingsFirstEvent.TextIsReceived(StateText.Text(text))
            } else {
                SettingsFirstEvent.TextIsReceived(StateText.ErrorText)
            }
        } else {
            SettingsFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: SettingsFirstEvent): Boolean {
        return event is SettingsFirstEvent.GetTextEvent
    }
}
