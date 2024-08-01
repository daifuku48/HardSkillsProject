package com.natifeuaandroid.domainmodule.features.mainFirst


class MainFirstReducer : com.natifeuaandroid.coremodule.Reducer<MainFirstState, MainFirstEvent> {
    override fun reduce(
        state: MainFirstState,
        event: MainFirstEvent,
    ): MainFirstState {
        return when (event) {
            is MainFirstEvent.ErrorEvent -> state
            is MainFirstEvent.GetMainTextEvent -> state
            is MainFirstEvent.MainTextIsReceived -> state.copy(text = event.text)
        }
    }

    override fun createInitialState(): MainFirstState {
        return MainFirstState()
    }
}
