package com.natifedanilharitonov.hardskillsproject.presentation.statisticsSecond

import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondState
import kotlinx.collections.immutable.PersistentList

data class StatisticsSecondUiState(
    val modelLines: PersistentList<Pair<Float, Float>>?,
    val modelColumns: PersistentList<Pair<Float, Float>>?
)

fun StatisticsSecondState.toUi(): StatisticsSecondUiState {
    return StatisticsSecondUiState(
        modelLines = modelLines,
        modelColumns = modelColumns
    )
}
