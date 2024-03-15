package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class RandomAnimeImageReducer : Reducer<RandomAnimeImageState, RandomAnimeImageEvent> {
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
}