package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model

import com.natifedanilharitonov.core.UiModel

data class RandomAnimeImageUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending
) : UiModel