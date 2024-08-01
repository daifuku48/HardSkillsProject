package com.natifeuaandroid.coremodule

interface Reducer<State, Event> {
    fun reduce(
        state: State,
        event: Event,
    ): State

    fun createInitialState(): State
}
