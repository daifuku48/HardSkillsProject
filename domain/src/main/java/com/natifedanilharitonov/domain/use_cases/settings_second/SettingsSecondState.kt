package com.natifedanilharitonov.domain.use_cases.settings_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.main.StateText

data class SettingsSecondState(
    val text: StateText = StateText.Pending
) : UiState