package com.natifeuaandroid.domainmodule.features.statisticsSecond

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class StatisticsSecondState(
    val modelLines: PersistentList<Pair<Float, Float>>? = persistentListOf(),
    val modelColumns: PersistentList<Pair<Float, Float>>? = persistentListOf()
)
