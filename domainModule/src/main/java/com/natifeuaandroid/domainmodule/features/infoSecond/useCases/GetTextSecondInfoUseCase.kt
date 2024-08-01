package com.natifeuaandroid.domainmodule.features.infoSecond.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondEvent
import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetTextSecondInfoUseCase(
    private val repository: MockTextRepository,
) : UseCase<InfoSecondState, InfoSecondEvent> {
    override suspend fun execute(
        state: InfoSecondState,
        event: InfoSecondEvent,
    ): InfoSecondEvent {
        return if (event is InfoSecondEvent.GetTextEvent) {
            val text = repository.getText()
            InfoSecondEvent.TextReceivedEvent(text)
        } else {
            InfoSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: InfoSecondEvent): Boolean {
        return event is InfoSecondEvent.GetTextEvent
    }
}
