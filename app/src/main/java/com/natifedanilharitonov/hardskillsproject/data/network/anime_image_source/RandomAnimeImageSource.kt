package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source

interface RandomAnimeImageSource {
    suspend fun getAnimeImage() : String
}