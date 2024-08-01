package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifeuaandroid.domainmodule.features.statistics.StatisticsState
import kotlinx.collections.immutable.PersistentList

data class StatisticsUiState(
    val statModel: PersistentList<Pair<Float, Float>>?,
)

fun StatisticsState.toUi(): StatisticsUiState {
    return StatisticsUiState(statModel = statModel)
}