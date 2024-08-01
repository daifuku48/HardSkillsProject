package com.natifeuaandroid.domainmodule.features.mainSecond

class MainSecondReducer : com.natifeuaandroid.coremodule.Reducer<MainSecondState, MainSecondEvent> {
    override fun reduce(
        state: MainSecondState,
        event: MainSecondEvent,
    ): MainSecondState {
        return when (event) {
            is MainSecondEvent.ErrorEvent -> state
            is MainSecondEvent.GetMainTextEvent -> state
            is MainSecondEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun createInitialState(): MainSecondState {
        return MainSecondState()
    }
}
