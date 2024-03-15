package com.natifedanilharitonov.hardskillsproject.presentation.user_list

import com.natifedanilharitonov.hardskillsproject.core.Reducer
import kotlinx.collections.immutable.toPersistentList

class UserListReducer : Reducer<UserListState, UserListEvent> {
    override fun reduce(state: UserListState, event: UserListEvent): UserListState {
        return when (event) {
            is UserListEvent.ErrorEvent -> state
            is UserListEvent.GetUsersEvent -> state.copy(userList = UserList.Pending)
            is UserListEvent.UsersIsReceived -> state.copy(userList = event.userList)
            is UserListEvent.PagingToEndEvent -> state
            is UserListEvent.PagingUserIsReceived -> state.copy(
                userList = UserList.List(
                    ((state.userList as UserList.List).userList + event.userList).toPersistentList()
                )
            )
        }
    }
}