package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.model.StatUiModel

@Composable
fun StatisticChart(modelState: StatUiModel) {
    when (modelState) {
        is StatUiModel.Error -> {
            ErrorStatistic()
        }

        is StatUiModel.Model -> {
            Stats(modelState.model)
        }

        is StatUiModel.Pending -> {
            PendingStats()
        }
    }
}
