package com.natifedanilharitonov.hardskillsproject.presentation.statistics

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.statistics.components.StatModel


sealed class StatisticsEvent : UiEvent {
    data object GetModelStatsEvent : StatisticsEvent()
    data class ModelStatsIsReceivedEvent(val stats: StatModel) : StatisticsEvent()
    data object ErrorEvent : StatisticsEvent()
}