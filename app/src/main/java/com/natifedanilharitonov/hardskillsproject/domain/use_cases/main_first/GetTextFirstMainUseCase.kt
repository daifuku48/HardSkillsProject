package com.natifedanilharitonov.hardskillsproject.domain.use_cases.main_first

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.main_first.MainFirstEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main_first.MainFirstState

class GetTextFirstMainUseCase(
    private val repository: MockTextRepository
) : UseCase<MainFirstState, MainFirstEvent> {
    override suspend fun execute(state: MainFirstState, event: MainFirstEvent): MainFirstEvent {
        return if (event is MainFirstEvent.GetMainTextEvent) {
            val text = repository.getText()
            if (text != null) {
                MainFirstEvent.MainTextIsReceived(StateText.Text(text))
            } else MainFirstEvent.MainTextIsReceived(StateText.ErrorText)
        } else MainFirstEvent.ErrorEvent
    }

    override fun canHandle(event: MainFirstEvent): Boolean {
        return event is MainFirstEvent.GetMainTextEvent
    }
}