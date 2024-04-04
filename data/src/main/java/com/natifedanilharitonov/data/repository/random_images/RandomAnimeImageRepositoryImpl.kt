package com.natifedanilharitonov.data.repository.random_images

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.anime_image_source.RandomAnimeImageSource
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository

internal class RandomAnimeImageRepositoryImpl(
    private val source: RandomAnimeImageSource
) : RandomAnimeImageRepository {
    override suspend fun getImage(): Bitmap? {
        return source.getAnimeImage()
    }
}