package com.natifedanilharitonov.data.network.imageDownloader

import android.graphics.Bitmap

interface ImageDownloaderSource {
    suspend fun loadImage(url: String): Bitmap
}
