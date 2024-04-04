package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel

data class RandomAnimeImageUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending
) : UiModel