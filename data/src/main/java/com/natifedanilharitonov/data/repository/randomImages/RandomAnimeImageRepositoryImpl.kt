package com.natifedanilharitonov.data.repository.randomImages

import android.graphics.Bitmap
import com.natifedanilharitonov.data.network.animeImageSource.RandomAnimeImageSource
import com.natifedanilharitonov.domain.repository.RandomAnimeImageRepository

internal class RandomAnimeImageRepositoryImpl(
    private val source: RandomAnimeImageSource,
) : RandomAnimeImageRepository {
    override suspend fun getImage(): Bitmap? {
        return source.getAnimeImage()
    }
}
