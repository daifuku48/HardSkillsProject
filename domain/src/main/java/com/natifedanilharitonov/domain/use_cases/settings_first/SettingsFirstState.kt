package com.natifedanilharitonov.domain.use_cases.settings_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.main.StateText

data class SettingsFirstState(
    val text: StateText = StateText.Pending
) : UiState