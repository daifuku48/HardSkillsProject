package com.natifedanilharitonov.domain.features.random_anime_image_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage

data class RandomAnimeImageFirstState(
    val image: AnimeImage = AnimeImage.ImagePending
) : UiState