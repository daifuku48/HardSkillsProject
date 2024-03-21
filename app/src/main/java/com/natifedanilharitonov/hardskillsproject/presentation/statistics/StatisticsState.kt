package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class StatisticsState(
    val text: StateText = StateText.Pending
) : UiState