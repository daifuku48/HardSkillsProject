package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst.components

import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.ErrorStatistic
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.PendingStats

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatisticsFirstContainer(
    model: PersistentList<Pair<Float, Float>>?,
    getStats: () -> Unit,
) {
    when (model) {
        null -> {
            ErrorStatistic()
        }

        persistentListOf<Pair<Float, Float>>() -> {
            PendingStats()
        }

        else -> {
            StatChartFirst(model = model, getStats = getStats)
        }
    }
}
