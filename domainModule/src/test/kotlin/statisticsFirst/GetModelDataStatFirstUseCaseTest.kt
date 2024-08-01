package statisticsFirst

import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstEvent
import com.natifeuaandroid.domainmodule.features.statisticsFirst.StatisticsFirstState
import com.natifeuaandroid.domainmodule.features.statisticsFirst.useCases.GetModelDataStatFirstUseCase
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetModelDataStatFirstUseCaseTest {
    private lateinit var useCase: GetModelDataStatFirstUseCase

    @Mock
    private lateinit var repository: RandomStatsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetModelDataStatFirstUseCase(repository)
    }

    @Test
    fun `get stats access`() =
        runTest {
            val list =
                persistentListOf(
                    Pair(1f, 2f),
                    Pair(2f, 3f),
                )

            Mockito.`when`(repository.getRandomStats()).thenReturn(list)
            val event =
                useCase.execute(
                    StatisticsFirstState(),
                    StatisticsFirstEvent.GetStatsModel,
                )

            if (event is StatisticsFirstEvent.StatsModelIsReceived) {
                if (event.model != null && event.model?.isNotEmpty() == true) {
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

            Mockito.`when`(repository.getRandomStats()).thenReturn(list)
            val event =
                useCase.execute(
                    StatisticsFirstState(),
                    StatisticsFirstEvent.GetStatsModel,
                )

            if (event is StatisticsFirstEvent.StatsModelIsReceived) {
                if (event.model == null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(StatisticsFirstEvent.GetStatsModel))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(StatisticsFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(StatisticsFirstEvent.StatsModelIsReceived(null)))
        }
}
