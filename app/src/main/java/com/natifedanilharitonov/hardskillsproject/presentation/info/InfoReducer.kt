package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifedanilharitonov.hardskillsproject.core.Reducer

class InfoReducer : Reducer<InfoState, InfoEvent> {
    override fun reduce(state: InfoState, event: InfoEvent): InfoState {
        return when (event) {
            is InfoEvent.ErrorEvent -> state
            is InfoEvent.GetUserInfoEvent -> state
            is InfoEvent.UserDataEventIsReceived -> state.copy(email = event.email)
        }
    }
}