package com.natifedanilharitonov.domain.features.random_anime_image

import com.natifedanilharitonov.core.UiState

data class RandomAnimeImageState(
    val image: AnimeImage = AnimeImage.ImagePending
) : UiState

