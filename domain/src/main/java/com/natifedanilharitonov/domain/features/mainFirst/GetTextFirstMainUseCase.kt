package com.natifedanilharitonov.domain.features.mainFirst

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextFirstMainUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainFirstState, MainFirstEvent> {
    override suspend fun execute(
        state: MainFirstState,
        event: MainFirstEvent,
    ): MainFirstEvent {
        return if (event is MainFirstEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainFirstEvent.MainTextIsReceived(StateText.Text(text))
            } else {
                MainFirstEvent.MainTextIsReceived(StateText.ErrorText)
            }
        } else {
            MainFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainFirstEvent): Boolean {
        return event is MainFirstEvent.GetMainTextEvent
    }
}