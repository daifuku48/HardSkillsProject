package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImageSecond

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.RandomAnimeImageSecondEvent
import com.natifedanilharitonov.domain.features.randomAnimeImageSecond.RandomAnimeImageSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel

class RandomAnimeImageSecondReducer(
    private val mapper: AnimeImage.Mapper<AnimeImageUiModel>,
) : Reducer<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent, RandomAnimeImageSecondUiState> {
    override fun reduce(
        state: RandomAnimeImageSecondState,
        event: RandomAnimeImageSecondEvent,
    ): RandomAnimeImageSecondState {
        return when (event) {
            is RandomAnimeImageSecondEvent.ErrorEvent -> state
            is RandomAnimeImageSecondEvent.GetRandomImageEvent -> state.copy(image = AnimeImage.ImagePending)
            is RandomAnimeImageSecondEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun mapToUiModel(state: RandomAnimeImageSecondState): RandomAnimeImageSecondUiState {
        return RandomAnimeImageSecondUiState(
            image = state.image.map(mapper),
        )
    }
}
