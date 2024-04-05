package com.natifedanilharitonov.domain.features.randomAnimeImage

import com.natifedanilharitonov.core.UiState

data class RandomAnimeImageState(
    val image: AnimeImage = AnimeImage.ImagePending,
) : UiState
