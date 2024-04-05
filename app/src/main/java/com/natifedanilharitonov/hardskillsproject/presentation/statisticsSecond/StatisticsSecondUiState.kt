package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.model.DoubleStatUiModel

data class StatisticsSecondUiState(
    val model: DoubleStatUiModel = DoubleStatUiModel.Pending,
) : UiModel
