package com.natifedanilharitonov.data.network.animeImageSource.model

import com.google.gson.annotations.SerializedName

data class AnimeImageNetwork(
    @SerializedName("items")
    val items: List<AnimeImageItemNetwork>,
)
