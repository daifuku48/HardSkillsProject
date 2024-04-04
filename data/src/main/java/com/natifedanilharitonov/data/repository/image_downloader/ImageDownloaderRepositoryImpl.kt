package com.natifedanilharitonov.data.repository.image_downloader

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.image_downloader.ImageDownloaderSource
import com.natifedanilharitonov.domain.repository.ImageDownloaderRepository

internal class ImageDownloaderRepositoryImpl(
    private val source: ImageDownloaderSource
) : ImageDownloaderRepository {
    override suspend fun loadImage(url: String): Bitmap {
        return source.loadImage(url)
    }
}