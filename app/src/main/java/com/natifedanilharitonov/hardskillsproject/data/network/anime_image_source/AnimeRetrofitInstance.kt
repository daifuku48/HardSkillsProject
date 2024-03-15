package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source

import com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.model.AnimeImageNetwork
import retrofit2.http.GET

interface AnimeRetrofitInstance {
    @GET("neko")
    suspend fun getRandomImage(): AnimeImageNetwork
}