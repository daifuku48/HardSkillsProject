package com.natifedanilharitonov.hardskillsproject.data.source.random_text

interface RandomTextSource {
    suspend fun getRandomText(): String?
}