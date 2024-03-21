package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class MainFirstState(
    val text: StateText = StateText.Pending
) : UiState