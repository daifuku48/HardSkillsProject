package com.natifedanilharitonov.data.network.animeImageSource.model

import com.google.gson.annotations.SerializedName

data class AnimeImageItemNetwork(
    @SerializedName("image_url")
    val url: String
)
