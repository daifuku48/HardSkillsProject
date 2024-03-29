package com.natifedanilharitonov.data.repository.mock_text

import com.natifedanilharitonov.data.source.random_text.RandomTextSource
import com.natifedanilharitonov.domain.repository.MockTextRepository

class MockTextRepositoryImpl(
    private val source: RandomTextSource
) : MockTextRepository {
    override suspend fun getText(): String? {
        return source.getRandomText()
    }
}