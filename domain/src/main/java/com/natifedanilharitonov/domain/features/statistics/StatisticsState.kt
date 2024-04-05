package com.natifedanilharitonov.domain.features.statistics

import com.natifedanilharitonov.core.UiState

data class StatisticsState(
    val statModel: StatModel = StatModel.Pending,
) : UiState
