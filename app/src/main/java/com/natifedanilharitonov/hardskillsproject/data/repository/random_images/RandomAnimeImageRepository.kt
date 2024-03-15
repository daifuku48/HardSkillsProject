package com.natifedanilharitonov.hardskillsproject.data.repository.random_images

import android.graphics.Bitmap

interface RandomAnimeImageRepository {
    suspend fun getImage() : Bitmap?
}