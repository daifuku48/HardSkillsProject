package com.natifedanilharitonov.data.network.image_downloader

import android.graphics.Bitmap

interface ImageDownloaderSource {
    suspend fun loadImage(url: String): Bitmap
}