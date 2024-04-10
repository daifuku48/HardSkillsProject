package com.natifedanilharitonov.domain.statisctics

import com.natifedanilharitonov.domain.features.statistics.GetModelStatsStatisticsUseCase
import com.natifedanilharitonov.domain.features.statistics.StatModel
import com.natifedanilharitonov.domain.features.statistics.StatisticsEvent
import com.natifedanilharitonov.domain.features.statistics.StatisticsState
import com.natifedanilharitonov.domain.repository.RandomStatsRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetModelStatsStatisticsUseCaseTest {
    private lateinit var useCase: GetModelStatsStatisticsUseCase

    @Mock
    private lateinit var repository: RandomStatsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetModelStatsStatisticsUseCase(repository)
    }

    @Test
    fun `get stats access`() =
        runTest {
            val list =
                persistentListOf(
                    Pair(1f, 2f),
                    Pair(2f, 3f),
                )

            `when`(repository.getRandomStats()).thenReturn(list)
            val event =
                useCase.execute(
                    StatisticsState(),
                    StatisticsEvent.GetModelStatsEvent,
                )

            if (event is StatisticsEvent.ModelStatsIsReceivedEvent) {
                if (event.stats is StatModel.Model) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `get stats error`() =
        runTest {
            val list = null

            `when`(repository.getRandomStats()).thenReturn(list)
            val event =
                useCase.execute(
                    StatisticsState(),
                    StatisticsEvent.GetModelStatsEvent,
                )

            if (event is StatisticsEvent.ModelStatsIsReceivedEvent) {
                if (event.stats is StatModel.Error) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(StatisticsEvent.GetModelStatsEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(StatisticsEvent.ErrorEvent))
            assert(!useCase.canHandle(StatisticsEvent.ModelStatsIsReceivedEvent(StatModel.Error)))
        }
}
