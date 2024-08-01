package com.natifeuaandroid.domainmodule.features.mainSecond.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondEvent
import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository

class GetTextSecondMainUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainSecondState, MainSecondEvent> {
    override suspend fun execute(
        state: MainSecondState,
        event: MainSecondEvent,
    ): MainSecondEvent {
        return if (event is MainSecondEvent.GetMainTextEvent) {
            val text = repository.getText()
            MainSecondEvent.MainTextIsReceived(text)
        } else {
            MainSecondEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainSecondEvent): Boolean {
        return event is MainSecondEvent.GetMainTextEvent
    }
}
