package com.natifedanilharitonov.hardskillsproject.data.source.stats

interface RandomStatsSource {
    suspend fun getRandomStats(): List<Pair<Float, Float>>?
}