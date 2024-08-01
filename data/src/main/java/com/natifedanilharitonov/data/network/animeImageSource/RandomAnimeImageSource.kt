package com.natifedanilharitonov.data.network.animeImageSource

interface RandomAnimeImageSource {
    suspend fun getAnimeImage(): String?
}
