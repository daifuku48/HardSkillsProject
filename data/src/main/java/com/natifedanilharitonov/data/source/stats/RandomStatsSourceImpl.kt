package com.natifedanilharitonov.data.source.stats

import kotlinx.coroutines.delay
import java.util.Random
import kotlin.random.asKotlinRandom

class RandomStatsSourceImpl : RandomStatsSource {
    private val random = Random()
    override suspend fun getRandomStats(): List<Pair<Float, Float>>? {
        val list = ArrayList<Pair<Float, Float>>(6)
        for (index in 0 until 7) {
            val randomInt = random.asKotlinRandom().nextDouble(10.0, 100.0)
            val randomFloat = randomInt.toFloat()
            list.add(Pair(index.toFloat(), randomFloat))
        }
        delay(300L)
        // for errors
        return if (Random().asKotlinRandom().nextInt(1, 100) < 5) {
            null
        } else list
    }
}