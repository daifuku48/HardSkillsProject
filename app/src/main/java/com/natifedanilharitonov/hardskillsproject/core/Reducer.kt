package com.natifedanilharitonov.hardskillsproject.core

interface Reducer<State : UiState, Event : UiEvent> {
    fun reduce(state: State, event: Event): State
}