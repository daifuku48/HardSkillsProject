package com.natifedanilharitonov.domain.use_cases.settings

import com.natifedanilharitonov.core.UiState

data class SettingsState(
    val isSignOutUser: Boolean = false
) : UiState