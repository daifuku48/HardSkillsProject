package com.natifeuaandroid.domainmodule.features.main.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.main.MainEvent
import com.natifeuaandroid.domainmodule.features.main.MainState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetMainTextUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainState, MainEvent> {
    override suspend fun execute(
        state: MainState,
        event: MainEvent,
    ): MainEvent {
        return if (event is MainEvent.GetMainTextEvent) {
            val text = repository.getText()
            MainEvent.MainTextIsReceived(text)
        } else {
            MainEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainEvent): Boolean {
        return event is MainEvent.GetMainTextEvent
    }
}
