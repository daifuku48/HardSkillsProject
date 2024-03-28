package com.natifedanilharitonov.hardskillsproject.presentation.statistics_first

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel

sealed class StatisticsFirstEvent : UiEvent {
    data object GetStatsModel : StatisticsFirstEvent()
    data class StatsModelIsReceived(val model: StatModel) : StatisticsFirstEvent()
    data object ErrorEvent : StatisticsFirstEvent()
}