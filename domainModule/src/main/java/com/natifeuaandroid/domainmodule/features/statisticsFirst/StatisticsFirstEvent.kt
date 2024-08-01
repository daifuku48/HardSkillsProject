package com.natifeuaandroid.domainmodule.features.statisticsFirst

import kotlinx.collections.immutable.PersistentList

sealed class StatisticsFirstEvent {
    data object GetStatsModel : StatisticsFirstEvent()

    data class StatsModelIsReceived(val model: PersistentList<Pair<Float, Float>>?) :
        StatisticsFirstEvent()

    data object ErrorEvent : StatisticsFirstEvent()
}
