package com.natifeuaandroid.domainmodule.features.userRandomFirst

import com.natifeuaandroid.coremodule.Reducer


class UserRandomFirstReducer :
    Reducer<UserRandomFirstState, UserRandomFirstEvent> {
    override fun reduce(
        state: UserRandomFirstState,
        event: UserRandomFirstEvent,
    ): UserRandomFirstState {
        return when (event) {
            is UserRandomFirstEvent.ErrorEvent -> state
            is UserRandomFirstEvent.GetRandomUserInfoEvent -> state.copy(
                isPending = true,
            )

            is UserRandomFirstEvent.RandomUserIsReceived -> state.copy(
                userResult = event.user,
                isPending = false
            )

            UserRandomFirstEvent.ShowUserErrorEvent -> state.copy(
                isPending = false,
                userResult = null
            )
        }
    }

    override fun createInitialState(): UserRandomFirstState {
        return UserRandomFirstState()
    }
}
