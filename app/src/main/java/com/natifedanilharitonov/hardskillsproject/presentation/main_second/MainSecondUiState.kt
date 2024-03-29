package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class MainSecondUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending
) : UiModel
