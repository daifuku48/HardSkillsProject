package com.natifedanilharitonov.hardskillsproject.presentation.settings_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class SettingsSecondUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending
) : UiModel