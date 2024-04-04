package com.natifedanilharitonov.data.repository.stats

import com.natifedanilharitonov.data.source.stats.RandomStatsSource
import com.natifedanilharitonov.domain.repository.RandomStatsRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

internal class RandomStatsRepositoryImpl(
    private val source: RandomStatsSource
) : RandomStatsRepository {
    override suspend fun getRandomStats(): PersistentList<Pair<Float, Float>>? {
        return source.getRandomStats()?.toPersistentList()
    }
}