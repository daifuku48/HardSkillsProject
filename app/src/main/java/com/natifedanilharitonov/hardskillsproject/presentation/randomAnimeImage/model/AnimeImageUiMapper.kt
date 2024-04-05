package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage

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
