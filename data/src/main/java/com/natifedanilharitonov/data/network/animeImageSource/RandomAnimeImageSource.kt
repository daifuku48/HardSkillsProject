package com.natifedanilharitonov.data.network.animeImageSource

import android.graphics.Bitmap

interface RandomAnimeImageSource {
    suspend fun getAnimeImage(): Bitmap?
}
