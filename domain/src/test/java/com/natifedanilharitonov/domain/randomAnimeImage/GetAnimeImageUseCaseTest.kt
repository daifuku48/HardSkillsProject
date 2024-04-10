package com.natifedanilharitonov.domain.randomAnimeImage

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.features.randomAnimeImage.GetAnimeImageUseCase
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageState
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
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
            `when`(repository.getImage()).thenReturn(mock<Bitmap>())
            val event =
                useCase.execute(RandomAnimeImageState(), RandomAnimeImageEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageEvent.RandomImageIsReceived) {
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
            `when`(repository.getImage()).thenReturn(null)
            val event =
                useCase.execute(RandomAnimeImageState(), RandomAnimeImageEvent.GetRandomImageEvent)
            if (event is RandomAnimeImageEvent.RandomImageIsReceived) {
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
            assert(useCase.canHandle(RandomAnimeImageEvent.GetRandomImageEvent))
        }

    @Test
    fun `invalid event`() =
        runTest {
            assert(!useCase.canHandle(RandomAnimeImageEvent.ErrorEvent))
            assert(!useCase.canHandle(RandomAnimeImageEvent.RandomImageIsReceived(AnimeImage.ImageError)))
        }
}
