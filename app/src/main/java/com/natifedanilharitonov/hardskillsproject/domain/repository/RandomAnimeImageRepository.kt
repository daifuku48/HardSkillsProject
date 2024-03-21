package com.natifedanilharitonov.hardskillsproject.domain.repository

import android.graphics.Bitmap

interface RandomAnimeImageRepository {
    suspend fun getImage() : Bitmap?
}