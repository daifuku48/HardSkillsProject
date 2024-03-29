package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.domain.use_cases.main.StateText

data class SettingsSecondUiState(
    val text: StateText = StateText.Pending
) : UiModel