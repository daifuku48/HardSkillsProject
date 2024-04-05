package com.natifedanilharitonov.data.network.imageDownloader

import android.graphics.Bitmap
import com.natifedanilharitonov.data.MainDispatcherRule
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ImageDownloaderSourceTest {
    private val url = "https://cdn.nekos.pro/neko/9a21ae7b01e14bb6b485ce2ab14c0975.jpg"

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Mock
    private lateinit var imageDownloaderSource: ImageDownloaderSource

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `download image success`() =
        runTest {
            val mockBitmap = mockk<Bitmap>()
            `when`(imageDownloaderSource.loadImage(url)).thenReturn(mockBitmap)
            val resultBitmap = imageDownloaderSource.loadImage(url)
            verify(imageDownloaderSource).loadImage(url) // verify the method is called
            assertEquals(mockBitmap, resultBitmap)
        }

    @Test
    fun `download image error`() =
        runTest {
            val error = Exception("Image loading error")
            `when`(imageDownloaderSource.loadImage(url)).thenThrow(error)

            try {
                imageDownloaderSource.loadImage(url)
                assert(false)
            } catch (e: Exception) {
                assert(true)
            }
        }
}