package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class MainSecondReducer : Reducer<MainSecondState, MainSecondEvent> {
    override fun reduce(state: MainSecondState, event: MainSecondEvent): MainSecondState {
        return when (event) {
            is MainSecondEvent.ErrorEvent -> state
            is MainSecondEvent.GetMainTextEvent -> state
            is MainSecondEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }
}