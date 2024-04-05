package com.natifedanilharitonov.hardskillsproject.presentation.settings

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.settings.SettingsEvent
import com.natifedanilharitonov.domain.features.settings.SettingsState

class SettingsReducer : Reducer<SettingsState, SettingsEvent, SettingsUiState> {
    override fun reduce(
        state: SettingsState,
        event: SettingsEvent,
    ): SettingsState {
        return when (event) {
            is SettingsEvent.ErrorEvent -> state
            is SettingsEvent.SignOutUserEvent -> state
            is SettingsEvent.UserIsSignedOutEvent -> state.copy(isSignOutUser = true)
        }
    }

    override fun mapToUiModel(state: SettingsState): SettingsUiState {
        return SettingsUiState(
            isSignOutUser = state.isSignOutUser,
        )
    }
}
