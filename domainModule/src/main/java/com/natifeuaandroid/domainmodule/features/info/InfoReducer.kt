package com.natifeuaandroid.domainmodule.features.info

import com.natifeuaandroid.coremodule.Reducer


class InfoReducer : Reducer<InfoState, InfoEvent> {
    override fun reduce(
        state: InfoState,
        event: InfoEvent,
    ): InfoState =
        when (event) {
            is InfoEvent.ErrorEvent -> state
            is InfoEvent.GetUserInfoEvent -> state
            is InfoEvent.UserDataEventIsReceived -> state.copy(email = event.email)
            InfoEvent.EmailErrorEvent -> state.copy(isErrorEmailText = true)
        }

    override fun createInitialState(): InfoState {
        return InfoState()
    }
}
