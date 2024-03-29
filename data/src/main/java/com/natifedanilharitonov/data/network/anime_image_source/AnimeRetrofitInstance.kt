package com.natifedanilharitonov.data.network.anime_image_source

import com.natifedanilharitonov.data.network.anime_image_source.model.AnimeImageNetwork
import retrofit2.http.GET

internal interface AnimeRetrofitInstance {
    @GET("neko")
    suspend fun getRandomImage(): AnimeImageNetwork
}