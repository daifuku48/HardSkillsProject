package com.natifedanilharitonov.domain.use_cases.statistics_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.statistics.StatModel

data class StatisticsFirstState(
    val model: StatModel = StatModel.Pending
) : UiState