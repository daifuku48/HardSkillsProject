package com.natifedanilharitonov.domain.features.settingsFirst

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class SettingsFirstState(
    val text: StateText = StateText.Pending,
) : UiState
