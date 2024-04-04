package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.user_random_first.UserRandomFirstEvent
import com.natifedanilharitonov.domain.features.user_random_first.UserRandomFirstState
import com.natifedanilharitonov.domain.features.user_random_first.UserResult
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserRandomFirstUiState
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultUiModel

class UserRandomFirstReducer(
    private val mapper: UserResult.Mapper<UserResultUiModel>
) : Reducer<UserRandomFirstState, UserRandomFirstEvent, UserRandomFirstUiState> {
    override fun reduce(
        state: UserRandomFirstState,
        event: UserRandomFirstEvent
    ): UserRandomFirstState {
        return when (event) {
            is UserRandomFirstEvent.ErrorEvent -> state
            is UserRandomFirstEvent.GetRandomUserInfoEvent -> state.copy(userResult = UserResult.Pending)
            is UserRandomFirstEvent.RandomUserIsReceived -> state.copy(userResult = event.user)
        }
    }

    override fun mapToUiModel(state: UserRandomFirstState): UserRandomFirstUiState {
        return UserRandomFirstUiState(
            userResult = state.userResult.map(mapper)
        )
    }
}