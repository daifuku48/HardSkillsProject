package com.natifedanilharitonov.domain.features.random_anime_image_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage

data class RandomAnimeImageSecondState(
    val image: AnimeImage = AnimeImage.ImagePending
) : UiState