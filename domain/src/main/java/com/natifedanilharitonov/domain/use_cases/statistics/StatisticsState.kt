package com.natifedanilharitonov.domain.use_cases.statistics

import com.natifedanilharitonov.core.UiState

data class StatisticsState(
    val statModel: StatModel = StatModel.Pending
) : UiState

