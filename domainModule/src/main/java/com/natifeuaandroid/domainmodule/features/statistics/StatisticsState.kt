package com.natifeuaandroid.domainmodule.features.statistics

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class StatisticsState(
    val statModel: PersistentList<Pair<Float, Float>>? = persistentListOf()
)
