package com.natifeuaandroid.domainmodule.features.userList

import com.natifeuaandroid.domainmodule.model.DomainUser
import kotlinx.collections.immutable.PersistentList


sealed class UserListEvent {
    data object GetUsersEvent : UserListEvent()

    data object PagingToEndEvent : UserListEvent()

    data class PagingUserIsReceived(
        val userList: PersistentList<DomainUser>?,
        val pagingValue: Int,
    ) : UserListEvent()

    data class UsersIsReceived(
        val userList: PersistentList<DomainUser>?,
        val pagingValue: Int,
    ) : UserListEvent()

    data object ErrorEvent : UserListEvent()
}
