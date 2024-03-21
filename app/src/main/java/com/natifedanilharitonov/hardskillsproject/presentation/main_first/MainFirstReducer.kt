package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class MainFirstReducer : Reducer<MainFirstState, MainFirstEvent> {
    override fun reduce(state: MainFirstState, event: MainFirstEvent): MainFirstState {
        return when (event) {
            is MainFirstEvent.ErrorEvent -> state
            is MainFirstEvent.GetMainTextEvent -> state
            is MainFirstEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }
}