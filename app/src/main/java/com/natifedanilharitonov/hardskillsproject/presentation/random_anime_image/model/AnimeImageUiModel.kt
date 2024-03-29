package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model

import android.graphics.Bitmap

interface AnimeImageUiModel {
    data object ImagePending : AnimeImageUiModel
    data class ImageAccess(val image: Bitmap) : AnimeImageUiModel
    data object ImageError : AnimeImageUiModel
}