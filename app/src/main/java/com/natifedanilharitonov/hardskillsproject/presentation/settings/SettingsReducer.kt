package com.natifedanilharitonov.hardskillsproject.presentation.settings

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class SettingsReducer : Reducer<SettingsState, SettingsEvent> {
    override fun reduce(state: SettingsState, event: SettingsEvent): SettingsState {
        return when (event) {
            is SettingsEvent.ErrorEvent -> state
            is SettingsEvent.SignOutUserEvent -> state
            is SettingsEvent.UserIsSignedOutEvent -> state.copy(isSignOutUser = true)
        }
    }
}