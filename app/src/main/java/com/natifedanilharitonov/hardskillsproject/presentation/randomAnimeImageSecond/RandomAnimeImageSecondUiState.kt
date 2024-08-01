package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond

import com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond.RandomAnimeImageSecondState

data class RandomAnimeImageSecondUiState(
    val image: String?,
)

fun RandomAnimeImageSecondState.toUi(): RandomAnimeImageSecondUiState {
    return RandomAnimeImageSecondUiState(
        image = image
    )
}
