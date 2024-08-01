package com.natifeuaandroid.domainmodule.features.randomAnimeImageFirst

import com.natifeuaandroid.coremodule.Reducer

class RandomAnimeImageFirstReducer :
    Reducer<RandomAnimeImageFirstState, RandomAnimeImageFirstEvent> {
    override fun reduce(
        state: RandomAnimeImageFirstState,
        event: RandomAnimeImageFirstEvent,
    ): RandomAnimeImageFirstState {
        return when (event) {
            is RandomAnimeImageFirstEvent.ErrorEvent -> state
            is RandomAnimeImageFirstEvent.GetRandomImageEvent -> state.copy(image = "")
            is RandomAnimeImageFirstEvent.RandomImageIsReceived -> state.copy(image = event.animeImage)
        }
    }

    override fun createInitialState(): RandomAnimeImageFirstState {
        return RandomAnimeImageFirstState()
    }
}
