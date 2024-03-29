package com.natifedanilharitonov.hardskillsproject.domain.use_cases.main_second

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.main_second.MainSecondEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main_second.MainSecondState

class GetTextSecondMainUseCase(
    private val repository: MockTextRepository
) : UseCase<MainSecondState, MainSecondEvent> {
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