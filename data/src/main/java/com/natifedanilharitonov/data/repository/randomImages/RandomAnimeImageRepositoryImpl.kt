package com.natifedanilharitonov.data.repository.randomImages

import com.natifedanilharitonov.data.network.animeImageSource.RandomAnimeImageSource
import com.natifeuaandroid.domainmodule.repository.RandomAnimeImageRepository

internal class RandomAnimeImageRepositoryImpl(
    private val source: RandomAnimeImageSource,
) : RandomAnimeImageRepository {
    override suspend fun getImage(): String? {
        return source.getAnimeImage()
    }
}
