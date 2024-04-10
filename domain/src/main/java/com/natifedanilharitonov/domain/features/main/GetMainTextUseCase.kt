package com.natifedanilharitonov.domain.features.main

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.MockTextRepository

class GetMainTextUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainState, MainEvent> {
    override suspend fun execute(
        state: MainState,
        event: MainEvent,
    ): MainEvent {
        return if (event is MainEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainEvent.MainTextIsReceived(StateText.Text(text))
            } else {
                MainEvent.MainTextIsReceived(StateText.ErrorText)
            }
        } else {
            MainEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainEvent): Boolean {
        return event is MainEvent.GetMainTextEvent
    }
}
