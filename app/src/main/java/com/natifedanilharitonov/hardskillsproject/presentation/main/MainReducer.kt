package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class MainReducer : Reducer<MainState, MainEvent> {
    override fun reduce(state: MainState, event: MainEvent): MainState {
        return when (event) {
            is MainEvent.ErrorEvent -> state
            is MainEvent.GetMainTextEvent -> state
            is MainEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }
}