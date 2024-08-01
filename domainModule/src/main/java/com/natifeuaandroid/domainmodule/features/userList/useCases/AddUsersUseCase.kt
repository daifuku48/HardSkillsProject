package com.natifeuaandroid.domainmodule.features.userList.useCases


import com.natifeuaandroid.coremodule.UseCase
import com.natifeuaandroid.domainmodule.Utils
import com.natifeuaandroid.domainmodule.features.userList.UserListEvent
import com.natifeuaandroid.domainmodule.features.userList.UserListState
import com.natifeuaandroid.domainmodule.repository.UsersRepository
import kotlinx.collections.immutable.toPersistentList

class AddUsersUseCase(
    private val repository: UsersRepository,
) : UseCase<UserListState, UserListEvent> {
    override suspend fun execute(
        state: UserListState,
        event: UserListEvent,
    ): UserListEvent {
        return if (event is UserListEvent.PagingToEndEvent) {
            val list = repository.getUsers()
            if (list.isEmpty()) {
                UserListEvent.ErrorEvent
            } else {
                val fullList = state.userList?.addAll(list)
                UserListEvent.UsersIsReceived(
                    userList = fullList?.toPersistentList(),
                    pagingValue = if (fullList?.size != null) fullList.size - Utils.PAGING_VALUE else 0,
                )
            }
        } else {
            UserListEvent.ErrorEvent
        }
    }

    override fun canHandle(event: UserListEvent): Boolean {
        return event is UserListEvent.PagingToEndEvent
    }
}
