package com.natifedanilharitonov.data.network.animeImageSource

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.imageDownloader.ImageDownloaderSource

internal class RandomAnimeImageSourceImpl(
    private val instance: AnimeRetrofitInstance,
    private val imageDownloaderSource: ImageDownloaderSource,
) : RandomAnimeImageSource {
    override suspend fun getAnimeImage(): Bitmap? {
        return try {
            val url = instance.getRandomImage().url
            imageDownloaderSource.loadImage(url)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
