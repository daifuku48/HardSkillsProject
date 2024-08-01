package com.natifedanilharitonov.data.network.animeImageSource


internal class RandomAnimeImageSourceImpl(
    private val instance: AnimeRetrofitInstance,
) : RandomAnimeImageSource {
    override suspend fun getAnimeImage(): String? {
        return try {
            instance.getRandomImage().items.first().url
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
