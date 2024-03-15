package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import android.graphics.Bitmap
import com.natifedanilharitonov.hardskillsproject.core.UiState

data class RandomAnimeImageState(
    val image: AnimeImage = AnimeImage.ImagePending
) : UiState

sealed class AnimeImage {
    data object ImagePending : AnimeImage()
    data class ImageAccess(val image: Bitmap) : AnimeImage()
    data object ImageError : AnimeImage()
}