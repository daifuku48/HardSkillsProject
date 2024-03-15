package com.natifedanilharitonov.hardskillsproject.domain.user_list

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.users.UsersRepository
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserList
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListEvent
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.UserListState

class GetUsersUseCase(
    private val repository: UsersRepository
) : UseCase<UserListState, UserListEvent> {
    override suspend fun execute(state: UserListState, event: UserListEvent): UserListEvent {
        return if (event is UserListEvent.GetUsersEvent) {
            val userList = repository.getUsers()
            if (userList.isEmpty()) {
                UserListEvent.UsersIsReceived(UserList.ErrorList)
            } else {
                UserListEvent.UsersIsReceived(UserList.List(userList))
            }
        } else UserListEvent.ErrorEvent
    }

    override fun canHandle(event: UserListEvent): Boolean {
        return event is UserListEvent.GetUsersEvent
    }
}