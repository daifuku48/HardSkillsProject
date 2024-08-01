package com.natifeuaandroid.domainmodule.features.userList.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.Utils.PAGING_VALUE
import com.natifeuaandroid.domainmodule.features.userList.UserListEvent
import com.natifeuaandroid.domainmodule.features.userList.UserListState
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import kotlinx.collections.immutable.persistentListOf

class GetUsersUseCase(
    private val repository: UsersRepository,
) : UseCase<UserListState, UserListEvent> {
    override suspend fun execute(
        state: UserListState,
        event: UserListEvent,
    ): UserListEvent {
        return if (event is UserListEvent.GetUsersEvent) {
            val userList = repository.getUsers()
            if (userList.isEmpty()) {
                UserListEvent.UsersIsReceived(persistentListOf(), 0)
            } else {
                UserListEvent.UsersIsReceived(
                    userList,
                    pagingValue = userList.size - PAGING_VALUE,
                )
            }
        } else {
            UserListEvent.ErrorEvent
        }
    }

    override fun canHandle(event: UserListEvent): Boolean {
        return event is UserListEvent.GetUsersEvent
    }
}
