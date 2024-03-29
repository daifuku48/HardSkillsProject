package com.natifedanilharitonov.domain.use_cases.user_list

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.repository.UsersRepository

class GetUsersUseCase(
    private val repository: UsersRepository
) : UseCase<UserListState, UserListEvent> {
    override suspend fun execute(state: UserListState, event: UserListEvent): UserListEvent {
        return if (event is UserListEvent.GetUsersEvent) {
            val userList = repository.getUsers()
            if (userList.isEmpty()) {
                UserListEvent.UsersIsReceived(UserListResult.ErrorList)
            } else {
                UserListEvent.UsersIsReceived(UserListResult.List(userList))
            }
        } else UserListEvent.ErrorEvent
    }

    override fun canHandle(event: UserListEvent): Boolean {
        return event is UserListEvent.GetUsersEvent
    }
}