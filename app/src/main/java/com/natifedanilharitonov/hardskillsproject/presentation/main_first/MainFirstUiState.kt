package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class MainFirstUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending
) : UiModel