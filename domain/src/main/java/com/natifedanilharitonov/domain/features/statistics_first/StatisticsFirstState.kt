package com.natifedanilharitonov.domain.features.statistics_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.statistics.StatModel

data class StatisticsFirstState(
    val model: StatModel = StatModel.Pending
) : UiState