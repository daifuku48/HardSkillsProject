package com.natifedanilharitonov.domain.features.statisticsSecond

import com.natifedanilharitonov.core.UiState

data class StatisticsSecondState(
    val model: DoubleStatModel = DoubleStatModel.Pending,
) : UiState
