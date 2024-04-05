package com.natifedanilharitonov.data.repository.imageDownloader

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.imageDownloader.ImageDownloaderSource
import com.natifedanilharitonov.domain.repository.ImageDownloaderRepository

internal class ImageDownloaderRepositoryImpl(
    private val source: ImageDownloaderSource,
) : ImageDownloaderRepository {
    override suspend fun loadImage(url: String): Bitmap {
        return source.loadImage(url)
    }
}
