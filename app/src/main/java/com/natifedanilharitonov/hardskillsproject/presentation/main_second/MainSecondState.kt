package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class MainSecondState(
    val text: StateText = StateText.Pending
): UiState