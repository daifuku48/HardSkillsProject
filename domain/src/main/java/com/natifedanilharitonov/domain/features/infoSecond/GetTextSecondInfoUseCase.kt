package com.natifedanilharitonov.domain.features.infoSecond

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextSecondInfoUseCase(
    private val repository: MockTextRepository,
) : UseCase<InfoSecondState, InfoSecondEvent> {
    override suspend fun execute(
        state: InfoSecondState,
        event: InfoSecondEvent,
    ): InfoSecondEvent {
        return if (event is InfoSecondEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                InfoSecondEvent.TextReceivedEvent(StateText.Text(text))
            } else {
                InfoSecondEvent.TextReceivedEvent(StateText.ErrorText)
            }
        } else {
            InfoSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: InfoSecondEvent): Boolean {
        return event is InfoSecondEvent.GetTextEvent
    }
}
