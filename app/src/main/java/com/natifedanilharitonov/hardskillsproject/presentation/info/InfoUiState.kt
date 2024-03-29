package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailUiState

data class InfoUiState(
    val email: InfoEmailUiState = InfoEmailUiState.Pending
) : UiModel