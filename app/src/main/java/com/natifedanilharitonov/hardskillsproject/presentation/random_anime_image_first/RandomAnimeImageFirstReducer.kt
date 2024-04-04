package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.random_anime_image.AnimeImage
import com.natifedanilharitonov.domain.features.random_anime_image_first.RandomAnimeImageFirstEvent
import com.natifedanilharitonov.domain.features.random_anime_image_first.RandomAnimeImageFirstState
import com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.model.AnimeImageUiModel

class RandomAnimeImageFirstReducer(
    private val mapper: AnimeImage.Mapper<AnimeImageUiModel>
) : Reducer<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent, RandomAnimeImageFirstUiState> {
    override fun reduce(
        state: RandomAnimeImageFirstState,
        event: RandomAnimeImageFirstEvent
    ): RandomAnimeImageFirstState {
        return when (event) {
            is RandomAnimeImageFirstEvent.ErrorEvent -> state
            is RandomAnimeImageFirstEvent.GetRandomImageEvent -> state.copy(image = AnimeImage.ImagePending)
            is RandomAnimeImageFirstEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun mapToUiModel(state: RandomAnimeImageFirstState): RandomAnimeImageFirstUiState {
        return RandomAnimeImageFirstUiState(
            image = state.image.map(mapper)
        )
    }
}