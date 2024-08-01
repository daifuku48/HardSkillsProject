package com.natifedanilharitonov.data.source.stats

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class RandomStatsSourceTest {
    @Test
    fun `getRandomStats returns list of pairs with correct size`() =
        runTest {
            val randomStatsSource = RandomStatsSourceImpl()
            val statsList = randomStatsSource.getRandomStats()
            Assert.assertNotNull(statsList)
            Assert.assertEquals(7, statsList?.size)
        }

    @Test
    fun `getRandomStats returns null with 5 percent probability`() =
        runTest {
            val mockedRandomStatsSource = mock(RandomStatsSourceImpl::class.java)
            `when`(mockedRandomStatsSource.getRandomStats()).thenAnswer {
                if ((0..99).random() < 5) {
                    null
                } else {
                    listOf(
                        Pair(1f, 2f),
                        Pair(2f, 3f),
                    )
                }
            }

            var nullCount = 0
            repeat(100) {
                val statsList = mockedRandomStatsSource.getRandomStats()
                if (statsList == null) {
                    nullCount++
                }
            }

            val probability = nullCount / 100.0
            Assert.assertTrue(probability in 0.04..0.1)
        }
}
