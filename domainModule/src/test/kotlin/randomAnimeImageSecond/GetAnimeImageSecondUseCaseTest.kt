package randomAnimeImageSecond

import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondState
import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.useCases.GetAnimeImageSecondUseCase
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAnimeImageSecondUseCaseTest {
    private lateinit var useCase: GetAnimeImageSecondUseCase

    @Mock
    private lateinit var repository: RandomAnimeImageRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetAnimeImageSecondUseCase(repository)
    }

    @Test
    fun `get anime access`() =
        runTest {
            Mockito.`when`(repository.getImage()).thenReturn("image")
            val event =
                useCase.execute(
                    RandomAnimeImageSecondState(),
                    RandomAnimeImageSecondEvent.GetRandomImageEvent
                )
            if (event is RandomAnimeImageSecondEvent.RandomImageIsReceived) {
                if (event.animeImage == "image") {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `get anime error`() =
        runTest {
            Mockito.`when`(repository.getImage()).thenReturn(null)
            val event =
                useCase.execute(
                    RandomAnimeImageSecondState(),
                    RandomAnimeImageSecondEvent.GetRandomImageEvent
                )
            if (event is RandomAnimeImageSecondEvent.RandomImageIsReceived) {
                if (event.animeImage == null) {
                    assert(true)
                }
            } else {
                assert(false)
            }
        }

    @Test
    fun `valid event`() =
        runTest {
            assert(useCase.canHandle(RandomAnimeImageSecondEvent.GetRandomImageEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(RandomAnimeImageSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(RandomAnimeImageSecondEvent.RandomImageIsReceived(null)))
        }
}
