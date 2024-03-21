package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class SettingsFirstReducer : Reducer<SettingsFirstState, SettingsFirstEvent> {
    override fun reduce(state: SettingsFirstState, event: SettingsFirstEvent): SettingsFirstState {
        return when (event) {
            is SettingsFirstEvent.ErrorEvent -> state
            is SettingsFirstEvent.GetTextEvent -> state
            is SettingsFirstEvent.TextIsReceived -> state.copy(text = event.text)
        }
    }
}