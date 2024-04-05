package com.natifedanilharitonov.hardskillsproject.presentation.mainSecond

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class MainSecondUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending,
) : UiModel
