package com.natifedanilharitonov.domain.features.statistics

import com.natifedanilharitonov.core.UiEvent

sealed class StatisticsEvent : UiEvent {
    data object GetModelStatsEvent : StatisticsEvent()

    data class ModelStatsIsReceivedEvent(val stats: StatModel) : StatisticsEvent()

    data object ErrorEvent : StatisticsEvent()
}
