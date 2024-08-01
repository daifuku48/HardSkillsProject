package com.natifeuaandroid.domainmodule.features.userRandomSecond

import com.natifeuaandroid.coremodule.Reducer


class UserRandomSecondReducer : Reducer<UserRandomSecondState, UserRandomSecondEvent> {
    override fun reduce(
        state: UserRandomSecondState,
        event: UserRandomSecondEvent,
    ): UserRandomSecondState {
        return when (event) {
            is UserRandomSecondEvent.ErrorEvent -> state
            is UserRandomSecondEvent.GetRandomUserInfo -> state.copy(
                isPending = true,
            )

            is UserRandomSecondEvent.RandomUserInfoIsReceived -> state.copy(
                userResult = event.userResult,
                isPending = false
            )

            UserRandomSecondEvent.RandomUserErrorEvent -> state.copy(
                userResult = null,
                isPending = false,
            )
        }
    }

    override fun createInitialState(): UserRandomSecondState {
        return UserRandomSecondState()
    }
}
