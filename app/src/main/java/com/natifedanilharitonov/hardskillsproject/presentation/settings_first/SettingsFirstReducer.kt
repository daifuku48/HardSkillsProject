package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.main.StateText
import com.natifedanilharitonov.domain.use_cases.settings_first.SettingsFirstEvent
import com.natifedanilharitonov.domain.use_cases.settings_first.SettingsFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

class SettingsFirstReducer(
    private val mapper: StateText.Mapper<StateTextUiModel>
) : Reducer<SettingsFirstState, SettingsFirstEvent, SettingsFirstUiState> {
    override fun reduce(state: SettingsFirstState, event: SettingsFirstEvent): SettingsFirstState {
        return when (event) {
            is SettingsFirstEvent.ErrorEvent -> state
            is SettingsFirstEvent.GetTextEvent -> state
            is SettingsFirstEvent.TextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun mapToUiModel(state: SettingsFirstState): SettingsFirstUiState {
        return SettingsFirstUiState(
            text = state.text.map(mapper)
        )
    }
}