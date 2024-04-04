package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.core.Reducer
import com.natifedanilharitonov.domain.features.user_list.UserListEvent
import com.natifedanilharitonov.domain.features.user_list.UserListResult
import com.natifedanilharitonov.domain.features.user_list.UserListState
import com.natifedanilharitonov.domain.features.user_list.UserPaginationResult
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiModel
import kotlinx.collections.immutable.toPersistentList


class UserListReducer(
    private val userMapper: UserListResult.Mapper<UserListUiModel>,
    private val pagingMapper: UserPaginationResult.Mapper<UserPaginationUiModel>
) : Reducer<UserListState, UserListEvent, UserListUiState> {
    override fun reduce(state: UserListState, event: UserListEvent): UserListState {
        return when (event) {
            is UserListEvent.ErrorEvent -> state
            is UserListEvent.GetUsersEvent -> state.copy(
                userList = UserListResult.Pending,
                canPaging = false
            )

            is UserListEvent.UsersIsReceived -> state.copy(
                userList = event.userList,
                canPaging = true
            )

            is UserListEvent.PagingToEndEvent -> state.copy(
                canPaging = false,
                pagingState = UserPaginationResult.Paging
            )

            is UserListEvent.PagingUserIsReceived -> state.copy(
                userList = UserListResult.List(
                    ((state.userList as UserListResult.List).userList + event.userList).toPersistentList()
                ),
                pagingState = UserPaginationResult.Idle
            )
        }
    }

    override fun mapToUiModel(state: UserListState): UserListUiState {
        return UserListUiState(
            userList = state.userList.map(userMapper),
            canPaging = state.canPaging,
            pagingState = state.pagingState.map(pagingMapper)
        )
    }
}