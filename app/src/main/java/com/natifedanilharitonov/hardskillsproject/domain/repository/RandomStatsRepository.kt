package com.natifedanilharitonov.hardskillsproject.domain.repository

import kotlinx.collections.immutable.PersistentList

interface RandomStatsRepository {
    suspend fun getRandomStats(): PersistentList<Pair<Float, Float>>?
}