package com.natifeuaandroid.domainmodule.features.settingsFirst

import com.natifeuaandroid.coremodule.Reducer

class SettingsFirstReducer : Reducer<SettingsFirstState, SettingsFirstEvent> {
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

    override fun createInitialState(): SettingsFirstState {
        return SettingsFirstState()
    }
}
