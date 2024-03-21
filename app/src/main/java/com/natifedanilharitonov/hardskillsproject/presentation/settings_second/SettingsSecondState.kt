package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class SettingsSecondState(
    val text: StateText = StateText.Pending
) : UiState