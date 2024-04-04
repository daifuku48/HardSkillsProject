package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel


data class StatisticsUiState(
    val statModel: StatUiModel = StatUiModel.Pending
) : UiModel