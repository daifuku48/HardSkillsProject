package com.natifedanilharitonov.data.network.animeImageSource

import com.natifedanilharitonov.data.network.animeImageSource.model.AnimeImageNetwork
import retrofit2.http.GET
import retrofit2.http.Query

internal interface AnimeRetrofitInstance {
    @GET("images/random")
    suspend fun getRandomImage(
        @Query("rating") rating: String = "safe",
        @Query("limit") limit: Int = 1
    ): AnimeImageNetwork
}
