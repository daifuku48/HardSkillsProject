package com.natifedanilharitonov.data.source.randomText

interface RandomTextSource {
    suspend fun getRandomText(): String?
}
