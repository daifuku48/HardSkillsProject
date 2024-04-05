package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstEvent
import com.natifedanilharitonov.domain.features.userRandomFirst.UserRandomFirstState
import com.natifedanilharitonov.domain.features.userRandomFirst.UserResult
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserRandomFirstUiState
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel

class UserRandomFirstReducer(
    private val mapper: UserResult.Mapper<UserResultUiModel>,
) : Reducer<UserRandomFirstState, UserRandomFirstEvent, UserRandomFirstUiState> {
    override fun reduce(
        state: UserRandomFirstState,
        event: UserRandomFirstEvent,
    ): UserRandomFirstState {
        return when (event) {
            is UserRandomFirstEvent.ErrorEvent -> state
            is UserRandomFirstEvent.GetRandomUserInfoEvent -> state.copy(userResult = UserResult.Pending)
            is UserRandomFirstEvent.RandomUserIsReceived -> state.copy(userResult = event.user)
        }
    }

    override fun mapToUiModel(state: UserRandomFirstState): UserRandomFirstUiState {
        return UserRandomFirstUiState(
            userResult = state.userResult.map(mapper),
        )
    }
}
