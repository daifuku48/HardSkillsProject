package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.main.MainEvent
import com.natifedanilharitonov.domain.use_cases.main.MainState
import com.natifedanilharitonov.domain.use_cases.main.StateText
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.MainUiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class MainReducer(
    private val textMapper: StateText.Mapper<StateTextUiModel>
) : Reducer<MainState, MainEvent, MainUiState> {
    override fun reduce(state: MainState, event: MainEvent): MainState {
        return when (event) {
            is MainEvent.ErrorEvent -> state
            is MainEvent.GetMainTextEvent -> state
            is MainEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: MainState): MainUiState {
        return MainUiState(
            text = state.text.map(textMapper)
        )
    }
}