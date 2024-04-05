package com.natifedanilharitonov.domain.features.settingsSecond

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class SettingsSecondState(
    val text: StateText = StateText.Pending,
) : UiState
