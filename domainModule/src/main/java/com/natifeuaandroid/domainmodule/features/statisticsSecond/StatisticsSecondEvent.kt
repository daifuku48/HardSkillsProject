package com.natifeuaandroid.domainmodule.features.statisticsSecond

import kotlinx.collections.immutable.PersistentList

sealed class StatisticsSecondEvent {
    data object GetDataModelEvent : StatisticsSecondEvent()

    data class DataModelIsReceivedEvent(
        val modelLines: PersistentList<Pair<Float, Float>>?,
        val modelColumns: PersistentList<Pair<Float, Float>>?
    ) : StatisticsSecondEvent()

    data object ErrorEvent : StatisticsSecondEvent()
}
