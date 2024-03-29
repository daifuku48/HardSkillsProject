package com.natifedanilharitonov.domain.use_cases.random_anime_image

import com.natifedanilharitonov.core.UiState

data class RandomAnimeImageState(
    val image: AnimeImage = AnimeImage.ImagePending
) : UiState

