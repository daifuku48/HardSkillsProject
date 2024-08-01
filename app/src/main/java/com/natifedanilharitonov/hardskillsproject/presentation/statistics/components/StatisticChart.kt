package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.runtime.Composable
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun StatisticChart(modelState: PersistentList<Pair<Float, Float>>?) {
    when (modelState) {
        null -> {
            ErrorStatistic()
        }

        persistentListOf<Pair<Float, Float>>() -> {
            PendingStats()
        }

        else -> {
            Stats(modelState)
        }
    }
}
