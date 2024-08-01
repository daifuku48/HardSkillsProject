package com.natifeuaandroid.domainmodule.features.infoFirst.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstEvent
import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetTextFirstInfoUseCase(
    private val repository: MockTextRepository,
) : UseCase<InfoFirstState, InfoFirstEvent> {
    override suspend fun execute(
        state: InfoFirstState,
        event: InfoFirstEvent,
    ): InfoFirstEvent {
        return if (event is InfoFirstEvent.GetTextEvent) {
            val text = repository.getText()
            InfoFirstEvent.TextReceivedEvent(text)
        } else {
            InfoFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: InfoFirstEvent): Boolean {
        return event is InfoFirstEvent.GetTextEvent
    }
}
