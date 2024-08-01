package com.natifeuaandroid.domainmodule.features.statistics

import kotlinx.collections.immutable.PersistentList

sealed class StatisticsEvent {
    data object GetModelStatsEvent : StatisticsEvent()

    data class ModelStatsIsReceivedEvent(val stats: PersistentList<Pair<Float, Float>>?) :
        StatisticsEvent()

    data object ErrorEvent : StatisticsEvent()
}
