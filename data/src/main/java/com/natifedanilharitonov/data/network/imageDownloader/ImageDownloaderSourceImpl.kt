package com.natifedanilharitonov.data.network.imageDownloader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.Coil
import coil.request.ImageRequest

internal class ImageDownloaderSourceImpl(
    private val context: Context,
) : ImageDownloaderSource {
    override suspend fun loadImage(url: String): Bitmap {
        val request =
            ImageRequest.Builder(context)
                .data(url)
                .allowHardware(false)
                .build()
        val result = Coil.imageLoader(context).execute(request).drawable
        return (result as BitmapDrawable).bitmap
    }
}
