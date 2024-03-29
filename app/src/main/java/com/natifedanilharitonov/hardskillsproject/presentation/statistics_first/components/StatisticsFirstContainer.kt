package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel

@Composable
fun StatisticsFirstContainer(model: StatUiModel, getStats: () -> Unit) {
    when (model) {
        is StatUiModel.Error -> {
            ErrorStatistic()
        }

        is StatUiModel.Model -> {
            StatChartFirst(model = model.model, getStats = getStats)
        }

        is StatUiModel.Pending -> {
            PendingStats()
        }
    }
}