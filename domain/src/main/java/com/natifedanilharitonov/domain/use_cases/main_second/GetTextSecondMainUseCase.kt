package com.natifedanilharitonov.domain.use_cases.main_second

import com.natifedanilharitonov.domain.repository.MockTextRepository
import com.natifedanilharitonov.domain.use_cases.main.StateText

class GetTextSecondMainUseCase(
    private val repository: MockTextRepository
) : com.natifedanilharitonov.core.UseCase<MainSecondState, MainSecondEvent> {
    override suspend fun execute(state: MainSecondState, event: MainSecondEvent): MainSecondEvent {
        return if (event is MainSecondEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainSecondEvent.MainTextIsReceived(StateText.Text(text))
            } else MainSecondEvent.MainTextIsReceived(StateText.ErrorText)
        } else MainSecondEvent.ErrorEvent
    }

    override fun canHandle(event: MainSecondEvent): Boolean {
        return event is MainSecondEvent.GetMainTextEvent
    }
}