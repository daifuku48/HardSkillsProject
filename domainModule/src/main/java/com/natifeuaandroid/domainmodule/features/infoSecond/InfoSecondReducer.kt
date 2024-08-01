package com.natifeuaandroid.domainmodule.features.infoSecond

class InfoSecondReducer :
    com.natifeuaandroid.coremodule.Reducer<InfoSecondState, InfoSecondEvent> {
    override fun reduce(
        state: InfoSecondState,
        event: InfoSecondEvent,
    ): InfoSecondState {
        return when (event) {
            is InfoSecondEvent.ErrorEvent -> state
            is InfoSecondEvent.GetTextEvent -> state.copy(isLoading = true)
            is InfoSecondEvent.TextReceivedEvent -> state.copy(text = event.text, isLoading = false)
        }
    }

    override fun createInitialState(): InfoSecondState {
        return InfoSecondState()
    }
}
