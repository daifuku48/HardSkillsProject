package com.natifedanilharitonov.core

interface Reducer<State : UiState, Event : UiEvent, Model : UiModel> {
    fun reduce(state: State, event: Event): State
    fun mapToUiModel(state: State): Model
}