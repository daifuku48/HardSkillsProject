package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.runtime.Composable

@Composable
fun StatisticChart(modelState: StatModel) {
    when (modelState) {
        is StatModel.Error -> {
            ErrorStatistic()
        }

        is StatModel.Model -> {
            Stats(modelState.model)
        }

        is StatModel.Pending -> {
            PendingStats()
        }
    }
}

