package com.natifedanilharitonov.domain.features.user_list

import com.natifedanilharitonov.core.UseCase
import com.natifedanilharitonov.domain.Utils
import com.natifedanilharitonov.domain.repository.UsersRepository
import kotlinx.collections.immutable.toPersistentList

class AddUsersUseCase(
    private val repository: UsersRepository
) : UseCase<UserListState, UserListEvent> {
    override suspend fun execute(state: UserListState, event: UserListEvent): UserListEvent {
        return if (event is UserListEvent.PagingToEndEvent) {
            val list = repository.getUsers()
            if (list.isEmpty()) {
                UserListEvent.ErrorEvent
            } else if (state.userList is UserListResult.List) {
                val fullList = state.userList.userList + list
                UserListEvent.UsersIsReceived(
                    userList = UserListResult.List(fullList.toPersistentList()),
                    pagingValue = fullList.size - Utils.PAGING_VALUE
                )
            } else UserListEvent.ErrorEvent
        } else UserListEvent.ErrorEvent
    }

    override fun canHandle(event: UserListEvent): Boolean {
        return event is UserListEvent.PagingToEndEvent
    }
}