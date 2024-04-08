package com.natifedanilharitonov.data.repository.randomImages

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.animeImageSource.RandomAnimeImageSource
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RandomAnimeImageRepositoryTest {
    private lateinit var repository: RandomAnimeImageRepository

    @Mock
    private lateinit var source: RandomAnimeImageSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = RandomAnimeImageRepositoryImpl(source)
    }

    @Test
    fun `get image access`() =
        runTest {
            val expected = mock<Bitmap>()
            `when`(repository.getImage()).thenReturn(expected)
            val actual = repository.getImage()
            assertEquals(expected, actual)
        }

    @Test
    fun `get image error`() =
        runTest {
            val expected = null
            `when`(repository.getImage()).thenReturn(expected)
            val actual = repository.getImage()
            assertEquals(expected, actual)
        }
}
