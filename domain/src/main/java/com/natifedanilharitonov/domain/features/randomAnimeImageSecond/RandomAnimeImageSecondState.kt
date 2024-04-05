package com.natifedanilharitonov.domain.features.randomAnimeImageSecond

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage

data class RandomAnimeImageSecondState(
    val image: AnimeImage = AnimeImage.ImagePending,
) : UiState
