package com.natifedanilharitonov.domain.features.statistics_second

import com.natifedanilharitonov.core.UiState

data class StatisticsSecondState(
    val model: DoubleStatModel = DoubleStatModel.Pending
) : UiState
