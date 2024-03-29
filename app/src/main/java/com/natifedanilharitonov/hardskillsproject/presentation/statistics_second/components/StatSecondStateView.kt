package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats
import com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.model.DoubleStatUiModel

@Composable
fun StatSecondStateView(
    model: DoubleStatUiModel,
) {
    when (model) {
        is DoubleStatUiModel.Error -> {
            ErrorStatistic()
        }

        is DoubleStatUiModel.Model -> {
            StatsSecond(
                modelLines = model.modelLines,
                modelColumns = model.modelColumns,
            )
        }

        is DoubleStatUiModel.Pending -> {
            PendingStats()
        }
    }
}