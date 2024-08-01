package com.natifedanilharitonov.hardskillsproject.presentation.statisticsFirst

import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstState
import kotlinx.collections.immutable.PersistentList

data class StatisticsFirstUiState(
    val model: PersistentList<Pair<Float, Float>>?,
)

fun StatisticsFirstState.toUi(): StatisticsFirstUiState {
    return StatisticsFirstUiState(
        model = model
    )
}
