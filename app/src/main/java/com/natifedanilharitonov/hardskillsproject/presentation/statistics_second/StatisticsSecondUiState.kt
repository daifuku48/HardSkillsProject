package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.DoubleStatUiModel

data class StatisticsSecondUiState(
    val model: DoubleStatUiModel = DoubleStatUiModel.Pending
) : UiModel
