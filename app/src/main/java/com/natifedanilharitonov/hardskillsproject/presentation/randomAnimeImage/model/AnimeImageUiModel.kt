package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model

import android.graphics.Bitmap
import androidx.compose.runtime.Stable

@Stable
interface AnimeImageUiModel {
    data object ImagePending : AnimeImageUiModel

    data class ImageAccess(val image: Bitmap) : AnimeImageUiModel

    data object ImageError : AnimeImageUiModel
}
