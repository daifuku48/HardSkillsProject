package com.natifedanilharitonov.hardskillsproject.data.repository.mock_text

import com.natifedanilharitonov.hardskillsproject.data.source.random_text.RandomTextSource
import com.natifedanilharitonov.hardskillsproject.domain.repository.MockTextRepository

class MockTextRepositoryImpl(
    private val source: RandomTextSource
) : MockTextRepository {
    override suspend fun getText(): String? {
        return source.getRandomText()
    }
}