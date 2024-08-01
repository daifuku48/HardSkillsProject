package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage

import com.natifeuaandroid.domainmodule.features.randomAnimeImage.RandomAnimeImageState

data class RandomAnimeImageUiState(
    val image: String?,
)


fun RandomAnimeImageState.toUi(): RandomAnimeImageUiState {
    return RandomAnimeImageUiState(
        image = image
    )
}