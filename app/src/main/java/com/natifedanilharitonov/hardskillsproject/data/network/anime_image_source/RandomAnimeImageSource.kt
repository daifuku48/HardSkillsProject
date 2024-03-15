package com.natifedanilharitonov.hardskillsproject.data.network.anime_image_source

import android.graphics.Bitmap

interface RandomAnimeImageSource {
    suspend fun getAnimeImage() : Bitmap?
}