package com.natifedanilharitonov.domain.features.settings_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class SettingsFirstState(
    val text: StateText = StateText.Pending
) : UiState