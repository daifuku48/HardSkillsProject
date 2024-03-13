package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source.model

import com.google.gson.annotations.SerializedName

data class AnimeImageNetwork(
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String
)