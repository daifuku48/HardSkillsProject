package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel
import kotlinx.collections.immutable.PersistentList

data class StatisticsState(
    val statModel: StatModel = StatModel.Pending
) : UiState

