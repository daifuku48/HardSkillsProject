package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.main_first.MainFirstEvent
import com.natifedanilharitonov.domain.features.main_first.MainFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class MainFirstReducer(
    private val textMapper: StateText.Mapper<StateTextUiModel>
) : Reducer<MainFirstState, MainFirstEvent, MainFirstUiState> {
    override fun reduce(state: MainFirstState, event: MainFirstEvent): MainFirstState {
        return when (event) {
            is MainFirstEvent.ErrorEvent -> state
            is MainFirstEvent.GetMainTextEvent -> state
            is MainFirstEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: MainFirstState): MainFirstUiState {
        return MainFirstUiState(
            text = state.text.map(textMapper)
        )
    }
}