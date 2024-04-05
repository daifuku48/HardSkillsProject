package com.natifedanilharitonov.domain.features.statisticsFirst

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.statistics.StatModel

data class StatisticsFirstState(
    val model: StatModel = StatModel.Pending,
) : UiState
