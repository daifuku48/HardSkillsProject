package com.natifedanilharitonov.domain.features.mainSecond

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetTextSecondMainUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainSecondState, MainSecondEvent> {
    override suspend fun execute(
        state: MainSecondState,
        event: MainSecondEvent,
    ): MainSecondEvent {
        return if (event is MainSecondEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainSecondEvent.MainTextIsReceived(StateText.Text(text))
            } else {
                MainSecondEvent.MainTextIsReceived(StateText.ErrorText)
            }
        } else {
            MainSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainSecondEvent): Boolean {
        return event is MainSecondEvent.GetMainTextEvent
    }
}
