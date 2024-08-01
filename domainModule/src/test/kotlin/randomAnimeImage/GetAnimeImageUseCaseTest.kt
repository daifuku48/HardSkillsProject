package randomAnimeImage

import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageState
import com.natifeuaandroid.domainmodule.features.randomAnimeImage.useCases.GetAnimeImageUseCase
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetAnimeImageUseCaseTest {
    private lateinit var useCase: GetAnimeImageUseCase

    @Mock
    private lateinit var repository: RandomAnimeImageRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetAnimeImageUseCase(repository)
    }

    @Test
    fun `get anime access`() =
        runTest {
            `when`(repository.getImage()).thenReturn("image")
            val event =
                useCase.execute(RandomAnimeImageState(), RandomAnimeImageEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageEvent.RandomImageIsReceived) {
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
            `when`(repository.getImage()).thenReturn(null)
            val event =
                useCase.execute(RandomAnimeImageState(), RandomAnimeImageEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageEvent.RandomImageIsReceived) {
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
            assert(useCase.canHandle(RandomAnimeImageEvent.GetRandomImageEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(RandomAnimeImageEvent.ErrorEvent))
            assert(!useCase.canHandle(RandomAnimeImageEvent.RandomImageIsReceived(null)))
        }
}
