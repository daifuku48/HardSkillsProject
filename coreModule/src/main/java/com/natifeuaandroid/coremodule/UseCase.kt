package com.natifeuaandroid.coremodule

interface UseCase<State, Event> {
    suspend fun execute(
        state: State,
        event: Event,
    ): Event

    fun canHandle(event: Event): Boolean
}
