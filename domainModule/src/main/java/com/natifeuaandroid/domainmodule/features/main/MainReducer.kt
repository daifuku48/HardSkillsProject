package com.natifeuaandroid.domainmodule.features.main

import com.natifeuaandroid.coremodule.Reducer


class MainReducer : Reducer<MainState, MainEvent> {
    override fun reduce(
        state: MainState,
        event: MainEvent,
    ): MainState {
        return when (event) {
            is MainEvent.ErrorEvent -> state
            is MainEvent.GetMainTextEvent -> state
            is MainEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun createInitialState(): MainState {
        return MainState()
    }
}
