package com.natifedanilharitonov.domain.use_cases.statistics_first

import com.natifedanilharitonov.core.UiEvent
import com.natifedanilharitonov.domain.use_cases.statistics.StatModel

sealed class StatisticsFirstEvent : UiEvent {
    data object GetStatsModel : StatisticsFirstEvent()
    data class StatsModelIsReceived(val model: StatModel) : StatisticsFirstEvent()
    data object ErrorEvent : StatisticsFirstEvent()
}