package com.natifedanilharitonov.data.repository.stats

import com.natifedanilharitonov.data.source.stats.RandomStatsSource
import com.natifedanilharitonov.domain.repository.RandomStatsRepository
import junit.framework.TestCase.assertEquals
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RandomStatsRepositoryTest {
    private lateinit var repository: RandomStatsRepository

    @Mock
    private lateinit var source: RandomStatsSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = RandomStatsRepositoryImpl(source)
    }

    @Test
    fun `get stats access`() =
        runTest {
            val expected =
                persistentListOf(
                    Pair(1f, 2f),
                    Pair(2f, 3f),
                    Pair(3f, 4f),
                    Pair(4f, 5f),
                    Pair(5f, 6f),
                    Pair(6f, 2f),
                )
            `when`(repository.getRandomStats()).thenReturn(expected)
            val actual = repository.getRandomStats()
            assertEquals(expected, actual)
        }

    @Test
    fun `get stats error`() =
        runTest {
            val expected = null
            `when`(repository.getRandomStats()).thenReturn(expected)
            val actual = repository.getRandomStats()
            assertEquals(expected, actual)
        }
}
