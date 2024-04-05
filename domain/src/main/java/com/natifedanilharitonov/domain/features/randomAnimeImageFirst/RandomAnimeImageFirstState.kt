package com.natifedanilharitonov.domain.features.randomAnimeImageFirst

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage

data class RandomAnimeImageFirstState(
    val image: AnimeImage = AnimeImage.ImagePending,
) : UiState
