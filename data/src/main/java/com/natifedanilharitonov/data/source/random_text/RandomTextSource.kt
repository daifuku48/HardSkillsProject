package com.natifedanilharitonov.data.source.random_text

interface RandomTextSource {
    suspend fun getRandomText(): String?
}