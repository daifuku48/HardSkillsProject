package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.randomAnimeImage.AnimeImage
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageEvent
import com.natifedanilharitonov.domain.features.randomAnimeImage.RandomAnimeImageState
import com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.model.AnimeImageUiModel

class RandomAnimeImageReducer(
    private val mapper: AnimeImage.Mapper<AnimeImageUiModel>,
) : Reducer<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState> {
    override fun reduce(
        state: RandomAnimeImageState,
        event: RandomAnimeImageEvent,
    ): RandomAnimeImageState {
        return when (event) {
            is RandomAnimeImageEvent.ErrorEvent -> state
            is RandomAnimeImageEvent.GetRandomImageEvent -> state.copy(image = AnimeImage.ImagePending)
            is RandomAnimeImageEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun mapToUiModel(state: RandomAnimeImageState): RandomAnimeImageUiState {
        return RandomAnimeImageUiState(
            image = state.image.map(mapper),
        )
    }
}
