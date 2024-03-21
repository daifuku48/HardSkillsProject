package com.natifedanilharitonov.hardskillsproject.domain.use_cases.main

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.MainState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

class GetMainTextUseCase(
    private val repository: MockTextRepository
) : UseCase<MainState, MainEvent> {
    override suspend fun execute(state: MainState, event: MainEvent): MainEvent {
        return if (event is MainEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainEvent.MainTextIsReceived(StateText.Text(text))
            } else MainEvent.MainTextIsReceived(StateText.ErrorText)
        } else MainEvent.ErrorEvent
    }

    override fun canHandle(event: MainEvent): Boolean {
        return event is MainEvent.GetMainTextEvent
    }
}