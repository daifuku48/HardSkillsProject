package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.random_anime_image.AnimeImage
import com.natifedanilharitonov.domain.use_cases.random_anime_image.RandomAnimeImageEvent
import com.natifedanilharitonov.domain.use_cases.random_anime_image.RandomAnimeImageState
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.RandomAnimeImageUiState

class RandomAnimeImageReducer(
    private val mapper: AnimeImage.Mapper<AnimeImageUiModel>
) : Reducer<RandomAnimeImageState, RandomAnimeImageEvent, RandomAnimeImageUiState> {
    override fun reduce(
        state: RandomAnimeImageState,
        event: RandomAnimeImageEvent
    ): RandomAnimeImageState {
        return when (event) {
            is RandomAnimeImageEvent.ErrorEvent -> state
            is RandomAnimeImageEvent.GetRandomImageEvent -> state.copy(image = AnimeImage.ImagePending)
            is RandomAnimeImageEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun mapToUiModel(state: RandomAnimeImageState): RandomAnimeImageUiState {
        return RandomAnimeImageUiState(
            image = state.image.map(mapper)
        )
    }
}