package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class SettingsFirstState(
    val text: StateText = StateText.Pending
) : UiState