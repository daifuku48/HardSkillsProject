package com.natifedanilharitonov.domain.use_cases.statistics_second

import com.natifedanilharitonov.core.UiState

data class StatisticsSecondState(
    val model: DoubleStatModel = DoubleStatModel.Pending
) : UiState
