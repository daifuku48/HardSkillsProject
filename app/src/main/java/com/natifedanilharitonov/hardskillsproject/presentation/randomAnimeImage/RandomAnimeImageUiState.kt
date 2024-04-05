package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel

data class RandomAnimeImageUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending,
) : UiModel
