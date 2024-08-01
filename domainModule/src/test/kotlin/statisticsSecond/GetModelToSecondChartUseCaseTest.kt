package statisticsSecond

import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondEvent
import com.natifeuaandroid.domainmodule.features.statisticsSecond.StatisticsSecondState
import com.natifeuaandroid.domainmodule.features.statisticsSecond.useCases.GetModelToSecondChartUseCase
import com.natifeuaandroid.domainmodule.repository.RandomStatsRepository
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetModelToSecondChartUseCaseTest {
    private lateinit var useCase: GetModelToSecondChartUseCase

    @Mock
    private lateinit var repository: RandomStatsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetModelToSecondChartUseCase(repository)
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
                    StatisticsSecondState(),
                    StatisticsSecondEvent.GetDataModelEvent,
                )

            if (event is StatisticsSecondEvent.DataModelIsReceivedEvent) {
                if (event.modelColumns != null && event.modelLines != null) {
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
                    StatisticsSecondState(),
                    StatisticsSecondEvent.GetDataModelEvent,
                )

            if (event is StatisticsSecondEvent.DataModelIsReceivedEvent) {
                if (event.modelColumns == null || event.modelLines == null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `correct event`() =
        runTest {
            assert(useCase.canHandle(StatisticsSecondEvent.GetDataModelEvent))
        }

    @Test
    fun `incorrect event`() =
        runTest {
            assert(!useCase.canHandle(StatisticsSecondEvent.ErrorEvent))
            assert(
                !useCase.canHandle(
                    StatisticsSecondEvent.DataModelIsReceivedEvent(
                        persistentListOf(), persistentListOf()
                    )
                )
            )
        }
}
