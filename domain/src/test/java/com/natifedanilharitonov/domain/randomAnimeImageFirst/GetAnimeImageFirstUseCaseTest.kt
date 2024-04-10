package com.natifedanilharitonov.domain.randomAnimeImageFirst

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.GetAnimeImageFirstUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.RandomAnimeImageFirstEvent
import com.natifedanilharitonov.domain.features.randomAnimeImageFirst.RandomAnimeImageFirstState
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository
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
            Mockito.`when`(repository.getImage()).thenReturn(Mockito.mock<Bitmap>())
            val event =
                useCase.execute(RandomAnimeImageFirstState(), RandomAnimeImageFirstEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageFirstEvent.RandomImageIsReceived) {
                if (event.animeImage is AnimeImage.ImageAccess) {
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
                useCase.execute(RandomAnimeImageFirstState(), RandomAnimeImageFirstEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageFirstEvent.RandomImageIsReceived) {
                if (event.animeImage is AnimeImage.ImageError) {
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
            assert(!useCase.canHandle(RandomAnimeImageFirstEvent.RandomImageIsReceived(AnimeImage.ImageError)))
        }
}
