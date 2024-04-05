package com.natifedanilharitonov.domain.features.infoFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextFirstInfoUseCase(
    private val repository: MockTextRepository,
) : UseCase<InfoFirstState, InfoFirstEvent> {
    override suspend fun execute(
        state: InfoFirstState,
        event: InfoFirstEvent,
    ): InfoFirstEvent {
        return if (event is InfoFirstEvent.GetTextEvent) {
            val text = repository.getText()
            if (text != null) {
                InfoFirstEvent.TextReceivedEvent(StateText.Text(text))
            } else {
                InfoFirstEvent.TextReceivedEvent(StateText.ErrorText)
            }
        } else {
            InfoFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: InfoFirstEvent): Boolean {
        return event is InfoFirstEvent.GetTextEvent
    }
}
