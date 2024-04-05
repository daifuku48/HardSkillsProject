package com.natifedanilharitonov.hardskillsproject.presentation.mainSecond

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.mainSecond.MainSecondEvent
import com.natifedanilharitonov.domain.features.mainSecond.MainSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class MainSecondReducer(
    private val textMapper: StateText.Mapper<StateTextUiModel>,
) : Reducer<MainSecondState, MainSecondEvent, MainSecondUiState> {
    override fun reduce(
        state: MainSecondState,
        event: MainSecondEvent,
    ): MainSecondState {
        return when (event) {
            is MainSecondEvent.ErrorEvent -> state
            is MainSecondEvent.GetMainTextEvent -> state
            is MainSecondEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: MainSecondState): MainSecondUiState {
        return MainSecondUiState(
            text = state.text.map(textMapper),
        )
    }
}
