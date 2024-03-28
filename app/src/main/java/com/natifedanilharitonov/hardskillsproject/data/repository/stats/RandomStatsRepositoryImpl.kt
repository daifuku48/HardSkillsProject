package com.natifedanilharitonov.hardskillsproject.data.repository.stats

import com.natifedanilharitonov.hardskillsproject.data.source.stats.RandomStatsSource
import com.natifedanilharitonov.hardskillsproject.domain.repository.RandomStatsRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class RandomStatsRepositoryImpl(
    private val source: RandomStatsSource
) : RandomStatsRepository {
    override suspend fun getRandomStats(): PersistentList<Pair<Float, Float>>? {
        return source.getRandomStats()?.toPersistentList()
    }
}