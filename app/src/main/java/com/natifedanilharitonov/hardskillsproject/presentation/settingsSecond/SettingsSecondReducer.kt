package com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.settingsSecond.SettingsSecondEvent
import com.natifedanilharitonov.domain.features.settingsSecond.SettingsSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class SettingsSecondReducer(
    private val textMapper: StateText.Mapper<StateTextUiModel>,
) :
    Reducer<SettingsSecondState, SettingsSecondEvent, SettingsSecondUiState> {
    override fun reduce(
        state: SettingsSecondState,
        event: SettingsSecondEvent,
    ): SettingsSecondState {
        return when (event) {
            is SettingsSecondEvent.ErrorEvent -> state
            is SettingsSecondEvent.GetTextEvent -> state
            is SettingsSecondEvent.TextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: SettingsSecondState): SettingsSecondUiState {
        return SettingsSecondUiState(
            text = state.text.map(textMapper),
        )
    }
}
