package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageFirst

import com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst.RandomAnimeImageFirstState

data class RandomAnimeImageFirstUiState(
    val image: String?,
)

fun RandomAnimeImageFirstState.toUi(): RandomAnimeImageFirstUiState {
    return RandomAnimeImageFirstUiState(image = image)
}
