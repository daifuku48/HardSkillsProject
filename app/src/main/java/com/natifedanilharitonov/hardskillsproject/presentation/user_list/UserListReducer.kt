package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.use_cases.user_list.UserListEvent
import com.natifedanilharitonov.domain.use_cases.user_list.UserListResult
import com.natifedanilharitonov.domain.use_cases.user_list.UserListState
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel
import kotlinx.collections.immutable.toPersistentList


class UserListReducer(
    private val mapper: UserListResult.Mapper<UserListUiModel>
) : Reducer<UserListState, UserListEvent, UserListUiState> {
    override fun reduce(state: UserListState, event: UserListEvent): UserListState {
        return when (event) {
            is UserListEvent.ErrorEvent -> state
            is UserListEvent.GetUsersEvent -> state.copy(userList = UserListResult.Pending)
            is UserListEvent.UsersIsReceived -> state.copy(userList = event.userList)
            is UserListEvent.PagingToEndEvent -> state
            is UserListEvent.PagingUserIsReceived -> state.copy(
                userList = UserListResult.List(
                    ((state.userList as UserListResult.List).userList + event.userList).toPersistentList()
                )
            )
        }
    }

    override fun mapToUiModel(state: UserListState): UserListUiState {
        return UserListUiState(
            userList = state.userList.map(mapper)
        )
    }
}