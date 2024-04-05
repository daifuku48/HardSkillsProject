package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel

data class RandomAnimeImageFirstUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending,
) : UiModel
