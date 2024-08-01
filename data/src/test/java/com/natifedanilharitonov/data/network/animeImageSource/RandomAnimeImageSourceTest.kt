package com.natifedanilharitonov.data.network.animeImageSource

import com.natifedanilharitonov.data.network.animeImageSource.model.AnimeImageItemNetwork
import com.natifedanilharitonov.data.network.animeImageSource.model.AnimeImageNetwork
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class RandomAnimeImageSourceTest {
    private lateinit var randomAnimeImageAccessSourceImpl: RandomAnimeImageSourceImpl
    private lateinit var randomAnimeImageErrorSourceImpl: RandomAnimeImageSourceImpl


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        randomAnimeImageAccessSourceImpl =
            RandomAnimeImageSourceImpl(
                AnimeMockInstance(),
            )
        randomAnimeImageErrorSourceImpl =
            RandomAnimeImageSourceImpl(
                AnimeErrorMockInstance(),
            )
    }

    @Test
    fun `get image access`() =
        runTest {
            val image = "https://cdn.nekos.pro/neko/9a21ae7b01e14bb6b485ce2ab14c0975.jpg"
            assertEquals(image, randomAnimeImageAccessSourceImpl.getAnimeImage())
        }

    @Test
    fun `get image error`() =
        runTest {
            assertNull(randomAnimeImageErrorSourceImpl.getAnimeImage())
        }
}

private class AnimeMockInstance : AnimeRetrofitInstance {
    override suspend fun getRandomImage(rating: String, limit: Int): AnimeImageNetwork {
        return AnimeImageNetwork(
            items = listOf(
                AnimeImageItemNetwork(
                    url = "https://cdn.nekos.pro/neko/9a21ae7b01e14bb6b485ce2ab14c0975.jpg"
                )
            )
        )
    }
}

private class AnimeErrorMockInstance : AnimeRetrofitInstance {
    override suspend fun getRandomImage(rating: String, limit: Int): AnimeImageNetwork {
        throw IllegalArgumentException()
    }
}
