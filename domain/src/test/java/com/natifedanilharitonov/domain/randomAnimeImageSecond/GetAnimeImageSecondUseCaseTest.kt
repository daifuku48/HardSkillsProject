package com.natifedanilharitonov.domain.randomAnimeImageSecond

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.GetAnimeImageSecondUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.RandomAnimeImageSecondEvent
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.RandomAnimeImageSecondState
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository
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
            Mockito.`when`(repository.getImage()).thenReturn(Mockito.mock<Bitmap>())
            val event =
                useCase.execute(RandomAnimeImageSecondState(), RandomAnimeImageSecondEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageSecondEvent.RandomImageIsReceived) {
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
                useCase.execute(RandomAnimeImageSecondState(), RandomAnimeImageSecondEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageSecondEvent.RandomImageIsReceived) {
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
            assert(useCase.canHandle(RandomAnimeImageSecondEvent.GetRandomImageEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(RandomAnimeImageSecondEvent.ErrorEvent))
            assert(!useCase.canHandle(RandomAnimeImageSecondEvent.RandomImageIsReceived(AnimeImage.ImageError)))
        }
}
