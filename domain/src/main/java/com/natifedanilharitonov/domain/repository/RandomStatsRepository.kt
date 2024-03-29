package com.natifedanilharitonov.domain.repository

import kotlinx.collections.immutable.PersistentList

interface RandomStatsRepository {
    suspend fun getRandomStats(): PersistentList<Pair<Float, Float>>?
}