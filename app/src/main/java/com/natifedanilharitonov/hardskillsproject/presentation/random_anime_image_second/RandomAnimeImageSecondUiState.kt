package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_second

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel

data class RandomAnimeImageSecondUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending
) : UiModel