package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source

class RandomAnimeImageSourceImpl(
    private val instance: AnimeRetrofitInstance
) : RandomAnimeImageSource {
    override suspend fun getAnimeImage(): String {
        return instance.getRandomImage().url
    }
}