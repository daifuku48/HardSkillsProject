package com.natifedanilharitonov.domain.repository

import android.graphics.Bitmap

interface ImageDownloaderRepository {
    suspend fun loadImage(url: String): Bitmap
}