package com.natifedanilharitonov.data.network.animeImageSource.model

import com.google.gson.annotations.SerializedName

data class AnimeImageNetwork(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
)
