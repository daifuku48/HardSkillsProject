package com.natifedanilharitonov.hardskillsproject.presentation.mainFirst

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class MainFirstUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending,
) : UiModel
