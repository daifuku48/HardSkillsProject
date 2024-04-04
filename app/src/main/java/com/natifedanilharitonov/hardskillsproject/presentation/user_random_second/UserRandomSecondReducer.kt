package com.natifedanilharitonov.hardskillsproject.presentation.user_random_second

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.user_random_first.UserResult
import com.natifedanilharitonov.domain.features.user_random_second.UserRandomSecondEvent
import com.natifedanilharitonov.domain.features.user_random_second.UserRandomSecondState
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultUiModel

class UserRandomSecondReducer(
    private val mapper: UserResult.Mapper<UserResultUiModel>
) : Reducer<UserRandomSecondState, UserRandomSecondEvent, UserRandomSecondUiState> {
    override fun reduce(
        state: UserRandomSecondState,
        event: UserRandomSecondEvent
    ): UserRandomSecondState {
        return when (event) {
            is UserRandomSecondEvent.ErrorEvent -> state
            is UserRandomSecondEvent.GetRandomUserInfo -> state.copy(userResult = UserResult.Pending)
            is UserRandomSecondEvent.RandomUserInfoIsReceived -> state.copy(userResult = event.userResult)
        }
    }

    override fun mapToUiModel(state: UserRandomSecondState): UserRandomSecondUiState {
        return UserRandomSecondUiState(
            userResult = state.userResult.map(mapper)
        )
    }
}