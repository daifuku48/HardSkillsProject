package com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.main.StateText
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstEvent
import com.natifedanilharitonov.domain.features.settingsFirst.SettingsFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class SettingsFirstReducer(
    private val mapper: StateText.Mapper<StateTextUiModel>,
) : Reducer<SettingsFirstState, SettingsFirstEvent, SettingsFirstUiState> {
    override fun reduce(
        state: SettingsFirstState,
        event: SettingsFirstEvent,
    ): SettingsFirstState {
        return when (event) {
            is SettingsFirstEvent.ErrorEvent -> state
            is SettingsFirstEvent.GetTextEvent -> state
            is SettingsFirstEvent.TextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: SettingsFirstState): SettingsFirstUiState {
        return SettingsFirstUiState(
            text = state.text.map(mapper),
        )
    }
}
