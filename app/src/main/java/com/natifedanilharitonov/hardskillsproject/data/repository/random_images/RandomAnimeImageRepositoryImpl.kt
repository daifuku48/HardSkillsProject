package com.natifedanilharitonov.hardskillsproject.data.repository.random_images

import android.graphics.Bitmap
import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.RandomAnimeImageSource

class RandomAnimeImageRepositoryImpl(
    private val source: RandomAnimeImageSource
) : RandomAnimeImageRepository {
    override suspend fun getImage(): Bitmap? {
        return source.getAnimeImage()
    }
}