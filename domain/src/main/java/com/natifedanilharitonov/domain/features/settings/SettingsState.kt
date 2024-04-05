package com.natifedanilharitonov.domain.features.settings

import com.natifedanilharitonov.core.UiState

data class SettingsState(
    val isSignOutUser: Boolean = false,
) : UiState
