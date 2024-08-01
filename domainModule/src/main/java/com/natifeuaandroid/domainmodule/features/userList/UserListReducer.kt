package com.natifeuaandroid.domainmodule.features.userList

import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList


class UserListReducer : com.natifeuaandroid.coremodule.Reducer<UserListState, UserListEvent> {
    override fun reduce(
        state: UserListState,
        event: UserListEvent,
    ): UserListState {
        return when (event) {
            is UserListEvent.ErrorEvent -> state
            is UserListEvent.GetUsersEvent ->
                state.copy(
                    canPaging = false,
                )

            is UserListEvent.UsersIsReceived ->
                state.copy(
                    userList = event.userList,
                    canPaging = true,
                )

            is UserListEvent.PagingToEndEvent ->
                state.copy(
                    canPaging = false,
                    pagingState = true,
                )

            is UserListEvent.PagingUserIsReceived ->
                state.copy(
                    userList = state.userList?.addAll(
                        event.userList?.toPersistentList() ?: persistentListOf()
                    ),
                    pagingState = false,
                )
        }
    }

    override fun createInitialState(): UserListState {
        return UserListState()
    }
}

