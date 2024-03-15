package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import coil.Coil
import coil.request.ImageRequest

class RandomAnimeImageSourceImpl(
    private val instance: AnimeRetrofitInstance,
    private val context: Context
) : RandomAnimeImageSource {
    override suspend fun getAnimeImage(): Bitmap? {
        return try {
            val request = ImageRequest.Builder(context)
                .data(instance.getRandomImage().url)
                .allowHardware(false)
                .build()
            val result = Coil.imageLoader(context).execute(request).drawable
            return (result as BitmapDrawable).bitmap
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}