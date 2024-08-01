package com.natifeuaandroid.domainmodule.repository

import kotlinx.collections.immutable.PersistentList

interface RandomStatsRepository {
    suspend fun getRandomStats(): PersistentList<Pair<Float, Float>>?
}
