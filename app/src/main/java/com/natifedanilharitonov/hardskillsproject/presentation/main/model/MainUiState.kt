package com.natifedanilharitonov.hardskillsproject.presentation.main.model

import com.natifedanilharitonov.core.UiModel

data class MainUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending
) : UiModel