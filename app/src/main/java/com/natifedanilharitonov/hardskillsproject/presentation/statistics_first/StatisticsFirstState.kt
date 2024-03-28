package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel

data class StatisticsFirstState(
    val model: StatModel = StatModel.Pending
) : UiState