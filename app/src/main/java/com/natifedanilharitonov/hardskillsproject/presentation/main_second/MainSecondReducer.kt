package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.main.StateText
import com.natifedanilharitonov.domain.use_cases.main_second.MainSecondEvent
import com.natifedanilharitonov.domain.use_cases.main_second.MainSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class MainSecondReducer(
    private val textMapper: StateText.Mapper<StateTextUiModel>
) : Reducer<MainSecondState, MainSecondEvent, MainSecondUiState> {
    override fun reduce(state: MainSecondState, event: MainSecondEvent): MainSecondState {
        return when (event) {
            is MainSecondEvent.ErrorEvent -> state
            is MainSecondEvent.GetMainTextEvent -> state
            is MainSecondEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: MainSecondState): MainSecondUiState {
        return MainSecondUiState(
            text = state.text.map(textMapper)
        )
    }
}