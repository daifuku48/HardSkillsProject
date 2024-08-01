package com.natifedanilharitonov.data.repository.mockText

import com.natifedanilharitonov.data.source.randomText.RandomTextSource
import com.natifeuaandroid.domainmodule.repository.MockTextRepository

internal class MockTextRepositoryImpl(
    private val source: RandomTextSource,
) : MockTextRepository {
    override suspend fun getText(): String? {
        return source.getRandomText()
    }
}
