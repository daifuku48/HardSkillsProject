package com.natifedanilharitonov.core

interface UseCase<State : UiState, Event : UiEvent> {
    suspend fun execute(
        state: State,
        event: Event,
    ): Event

    fun canHandle(event: Event): Boolean
}
