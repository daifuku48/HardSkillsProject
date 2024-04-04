package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_first

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel

data class RandomAnimeImageFirstUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending
) : UiModel