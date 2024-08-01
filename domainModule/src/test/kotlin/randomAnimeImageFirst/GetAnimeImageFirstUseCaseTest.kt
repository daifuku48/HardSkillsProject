package randomAnimeImageFirst

import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstState
import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.useCases.GetAnimeImageFirstUseCase
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetAnimeImageFirstUseCaseTest {
    private lateinit var useCase: GetAnimeImageFirstUseCase

    @Mock
    private lateinit var repository: RandomAnimeImageRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetAnimeImageFirstUseCase(repository)
    }

    @Test
    fun `get anime access`() =
        runTest {
            Mockito.`when`(repository.getImage()).thenReturn("image")
            val event =
                useCase.execute(
                    RandomAnimeImageFirstState(),
                    RandomAnimeImageFirstEvent.GetRandomImageEvent
                )
            if (event is RandomAnimeImageFirstEvent.RandomImageIsReceived) {
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
                    RandomAnimeImageFirstState(),
                    RandomAnimeImageFirstEvent.GetRandomImageEvent
                )
            if (event is RandomAnimeImageFirstEvent.RandomImageIsReceived) {
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
            assert(useCase.canHandle(RandomAnimeImageFirstEvent.GetRandomImageEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(RandomAnimeImageFirstEvent.ErrorEvent))
            assert(!useCase.canHandle(RandomAnimeImageFirstEvent.RandomImageIsReceived(null)))
        }
}
