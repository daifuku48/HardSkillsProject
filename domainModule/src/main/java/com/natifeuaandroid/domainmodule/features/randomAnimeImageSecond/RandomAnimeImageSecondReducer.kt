package com.natifeuaandroid.domainmodule.features.randomAnimeImageSecond

import com.natifeuaandroid.coremodule.Reducer

class RandomAnimeImageSecondReducer :
    Reducer<RandomAnimeImageSecondState, RandomAnimeImageSecondEvent> {
    override fun reduce(
        state: RandomAnimeImageSecondState,
        event: RandomAnimeImageSecondEvent,
    ): RandomAnimeImageSecondState {
        return when (event) {
            is RandomAnimeImageSecondEvent.ErrorEvent -> state
            is RandomAnimeImageSecondEvent.GetRandomImageEvent -> state.copy(image = "")
            is RandomAnimeImageSecondEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun createInitialState(): RandomAnimeImageSecondState {
        return RandomAnimeImageSecondState()
    }
}
