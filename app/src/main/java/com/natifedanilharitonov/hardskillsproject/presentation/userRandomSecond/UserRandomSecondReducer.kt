package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult
import com.natifedanilharitonov.domain.features.userRandomSecond.UserRandomSecondEvent
import com.natifedanilharitonov.domain.features.userRandomSecond.UserRandomSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel

class UserRandomSecondReducer(
    private val mapper: UserResult.Mapper<UserResultUiModel>,
) : Reducer<UserRandomSecondState, UserRandomSecondEvent, UserRandomSecondUiState> {
    override fun reduce(
        state: UserRandomSecondState,
        event: UserRandomSecondEvent,
    ): UserRandomSecondState {
        return when (event) {
            is UserRandomSecondEvent.ErrorEvent -> state
            is UserRandomSecondEvent.GetRandomUserInfo -> state.copy(userResult = UserResult.Pending)
            is UserRandomSecondEvent.RandomUserInfoIsReceived -> state.copy(userResult = event.userResult)
        }
    }

    override fun mapToUiModel(state: UserRandomSecondState): UserRandomSecondUiState {
        return UserRandomSecondUiState(
            userResult = state.userResult.map(mapper),
        )
    }
}
