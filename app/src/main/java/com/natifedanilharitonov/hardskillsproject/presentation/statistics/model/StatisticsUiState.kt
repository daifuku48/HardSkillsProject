package com.natifedanilharitonov.hardskillsproject.presentation.statistics.model

import com.natifedanilharitonov.core.UiModel

data class StatisticsUiState(
    val statModel: StatUiModel = StatUiModel.Pending
) : UiModel