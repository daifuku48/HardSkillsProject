package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel

@Composable
fun StatisticsFirstContainer(model: StatModel, getStats: () -> Unit) {
    when (model) {
        is StatModel.Error -> {
            ErrorStatistic()
        }

        is StatModel.Model -> {
            StatChartFirst(model = model.model, getStats = getStats)
        }

        is StatModel.Pending -> {
            PendingStats()
        }
    }
}