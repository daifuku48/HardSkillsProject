package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class SettingsSecondReducer : Reducer<SettingsSecondState, SettingsSecondEvent> {
    override fun reduce(
        state: SettingsSecondState,
        event: SettingsSecondEvent
    ): SettingsSecondState {
        return when (event) {
            is SettingsSecondEvent.ErrorEvent -> state
            is SettingsSecondEvent.GetTextEvent -> state
            is SettingsSecondEvent.TextIsReceived -> state.copy(text = event.text)
        }
    }
}