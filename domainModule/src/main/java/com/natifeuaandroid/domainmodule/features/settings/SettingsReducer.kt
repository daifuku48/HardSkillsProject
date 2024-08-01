package com.natifeuaandroid.domainmodule.features.settings

import com.natifeuaandroid.coremodule.Reducer

class SettingsReducer :
    Reducer<SettingsState, SettingsEvent> {
    override fun reduce(
        state: SettingsState,
        event: SettingsEvent,
    ): SettingsState {
        return when (event) {
            is SettingsEvent.ErrorEvent -> state
            is SettingsEvent.SignOutUserEvent -> state
            is SettingsEvent.UserIsSignedOutEvent -> state
        }
    }

    override fun createInitialState(): SettingsState {
        return SettingsState()
    }
}
