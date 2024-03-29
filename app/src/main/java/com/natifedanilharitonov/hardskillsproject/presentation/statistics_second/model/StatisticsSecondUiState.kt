package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model

import com.natifedanilharitonov.core.UiModel

data class StatisticsSecondUiState(
    val model: DoubleStatUiModel = DoubleStatUiModel.Pending
) : UiModel
