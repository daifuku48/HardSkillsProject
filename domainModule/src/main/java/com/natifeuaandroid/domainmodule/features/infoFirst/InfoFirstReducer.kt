package com.natifeuaandroid.domainmodule.features.infoFirst

import com.natifeuaandroid.coremodule.Reducer


class InfoFirstReducer : Reducer<InfoFirstState, InfoFirstEvent> {
    override fun reduce(
        state: InfoFirstState,
        event: InfoFirstEvent,
    ): InfoFirstState {
        return when (event) {
            is InfoFirstEvent.ErrorEvent -> state
            is InfoFirstEvent.GetTextEvent -> state.copy(isLoading = true)
            is InfoFirstEvent.TextReceivedEvent -> state.copy(text = event.text, isLoading = false)
        }
    }


    override fun createInitialState(): InfoFirstState {
        return InfoFirstState()
    }
}
