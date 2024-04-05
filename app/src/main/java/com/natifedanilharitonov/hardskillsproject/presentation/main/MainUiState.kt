package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel

data class MainUiState(
    val text: StateTextUiModel = StateTextUiModel.Pending,
) : UiModel
