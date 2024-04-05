package com.natifedanilharitonov.data.network.animeImageSource

import com.natifedanilharitonov.data.MainDispatcherRule
import com.natifedanilharitonov.data.network.animeImageSource.model.AnimeImageNetwork
import com.natifedanilharitonov.data.network.imageDownloader.ImageDownloaderSource
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class RandomAnimeImageSourceTest {
    private lateinit var randomAnimeImageAccessSourceImpl: RandomAnimeImageSourceImpl
    private lateinit var randomAnimeImageErrorSourceImpl: RandomAnimeImageSourceImpl

    @Mock
    private lateinit var source: ImageDownloaderSource

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        randomAnimeImageAccessSourceImpl = RandomAnimeImageSourceImpl(
            AnimeMockInstance(),
            source
        )
        randomAnimeImageErrorSourceImpl = RandomAnimeImageSourceImpl(
            AnimeErrorMockInstance(),
            source
        )
    }

    @Test
    fun `get image access`() = runTest {
        val image =
            source.loadImage("https://cdn.nekos.pro/neko/9a21ae7b01e14bb6b485ce2ab14c0975.jpg")
        assertEquals(image, randomAnimeImageAccessSourceImpl.getAnimeImage())
    }

    @Test
    fun `get image error`() = runTest {
        assertNull(randomAnimeImageErrorSourceImpl.getAnimeImage())
    }
}

private class AnimeMockInstance : AnimeRetrofitInstance {
    override suspend fun getRandomImage(): AnimeImageNetwork {
        return AnimeImageNetwork(
            id = "123",
            url = "https://cdn.nekos.pro/neko/9a21ae7b01e14bb6b485ce2ab14c0975.jpg"
        )
    }
}

private class AnimeErrorMockInstance : AnimeRetrofitInstance {
    override suspend fun getRandomImage(): AnimeImageNetwork {
        throw Exception("Error occurred while fetching image")
    }
}

