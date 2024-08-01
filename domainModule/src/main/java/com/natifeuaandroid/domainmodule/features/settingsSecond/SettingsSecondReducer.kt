package com.natifeuaandroid.domainmodule.features.settingsSecond

import com.natifeuaandroid.coremodule.Reducer

class SettingsSecondReducer :
    Reducer<SettingsSecondState, SettingsSecondEvent> {
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

    override fun createInitialState(): SettingsSecondState {
        return SettingsSecondState()
    }
}
