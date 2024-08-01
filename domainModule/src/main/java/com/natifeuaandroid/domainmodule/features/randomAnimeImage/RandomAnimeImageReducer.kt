package com.natifeuaandroid.domainmodule.features.randomAnimeImage

import com.natifeuaandroid.coremodule.Reducer

class RandomAnimeImageReducer : Reducer<RandomAnimeImageState, RandomAnimeImageEvent> {
    override fun reduce(
        state: RandomAnimeImageState,
        event: RandomAnimeImageEvent,
    ): RandomAnimeImageState {
        return when (event) {
            is RandomAnimeImageEvent.ErrorEvent -> state
            is RandomAnimeImageEvent.GetRandomImageEvent -> state.copy(image = "")
            is RandomAnimeImageEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun createInitialState(): RandomAnimeImageState {
        return RandomAnimeImageState()
    }
}
