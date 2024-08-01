package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats
import kotlinx.collections.immutable.PersistentList

@Composable
fun StatSecondStateView(
    modelLines: PersistentList<Pair<Float, Float>>?,
    modelColumns: PersistentList<Pair<Float, Float>>?
) {
    if (modelLines?.isEmpty() == true || modelColumns?.isEmpty() == true) {
        PendingStats()
    } else if (modelLines == null || modelColumns == null) {
        ErrorStatistic()
    } else {
        StatsSecond(
            modelLines = modelLines,
            modelColumns = modelColumns,
        )
    }
}
