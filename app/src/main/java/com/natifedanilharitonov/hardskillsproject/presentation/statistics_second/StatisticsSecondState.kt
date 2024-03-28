package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components.DoubleStatModel

data class StatisticsSecondState(
    val model: DoubleStatModel = DoubleStatModel.Pending
) : UiState
