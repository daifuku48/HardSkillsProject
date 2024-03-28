package com.natifedanilharitonov.hardskillsproject.presentation.statistics_second.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats

@Composable
fun StatSecondStateView(
    model: DoubleStatModel,
) {
    when (model) {
        is DoubleStatModel.Error -> {
            ErrorStatistic()
        }

        is DoubleStatModel.Model -> {
            StatsSecond(
                modelLines = model.modelLines,
                modelColumns = model.modelColumns,
            )
        }

        is DoubleStatModel.Pending -> {
            PendingStats()
        }
    }
}