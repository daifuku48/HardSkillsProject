package com.natifedanilharitonov.domain.repository

import android.graphics.Bitmap

interface RandomAnimeImageRepository {
    suspend fun getImage() : Bitmap?
}