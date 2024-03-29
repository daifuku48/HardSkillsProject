package com.natifedanilharitonov.hardskillsproject.presentation.settings_first

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class SettingsFirstUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending
) : UiModel