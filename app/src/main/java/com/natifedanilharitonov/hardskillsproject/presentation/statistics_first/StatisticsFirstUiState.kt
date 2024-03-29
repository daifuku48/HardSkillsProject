package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel

data class StatisticsFirstUiState(
    val model: StatUiModel = StatUiModel.Pending
) : UiModel
