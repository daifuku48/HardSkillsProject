package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage

class AnimeImageUiMapper : AnimeImage.Mapper<AnimeImageUiModel> {
    override fun mapImagePending(): AnimeImageUiModel {
        return AnimeImageUiModel.ImagePending
    }

    override fun mapImageAccess(image: Bitmap): AnimeImageUiModel {
        return AnimeImageUiModel.ImageAccess(image)
    }

    override fun mapImageError(): AnimeImageUiModel {
        return AnimeImageUiModel.ImageError
    }
}