package com.natifeuaandroid.domainmodule.features.mainFirst.useCases

import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstEvent
import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstState
import com.natifeuaandroid.domainmodule.repository.MockTextRepository


class GetTextFirstMainUseCase(
    private val repository: MockTextRepository,
) : UseCase<MainFirstState, MainFirstEvent> {
    override suspend fun execute(
        state: MainFirstState,
        event: MainFirstEvent,
    ): MainFirstEvent {
        return if (event is MainFirstEvent.GetMainTextEvent) {
            val text = repository.getText()
            MainFirstEvent.MainTextIsReceived(text)
        } else {
            MainFirstEvent.ErrorEvent
        }
    }

    override fun canHandle(event: MainFirstEvent): Boolean {
        return event is MainFirstEvent.GetMainTextEvent
    }
}
