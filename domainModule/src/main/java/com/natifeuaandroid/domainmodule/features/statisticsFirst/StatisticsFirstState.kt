package com.natifeuaandroid.domainmodule.features.statisticsFirst

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class StatisticsFirstState(
    val model: PersistentList<Pair<Float, Float>>? = persistentListOf(),
)
