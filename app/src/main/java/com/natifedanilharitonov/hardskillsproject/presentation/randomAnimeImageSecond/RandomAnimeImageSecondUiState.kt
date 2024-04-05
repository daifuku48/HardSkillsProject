package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel

data class RandomAnimeImageSecondUiState(
    val image: AnimeImageUiModel = AnimeImageUiModel.ImagePending,
) : UiModel
