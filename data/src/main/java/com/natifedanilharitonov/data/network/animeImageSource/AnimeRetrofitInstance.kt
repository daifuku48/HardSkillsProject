package com.natifedanilharitonov.data.network.animeImageSource

import com.natifedanilharitonov.data.network.animeImageSource.model.AnimeImageNetwork
import retrofit2.http.GET

internal interface AnimeRetrofitInstance {
    @GET("neko")
    suspend fun getRandomImage(): AnimeImageNetwork
}
