package com.natifeuaandroid.domainmodule.features.userList

import com.natifeuaandroid.domainmodule.model.DomainUser
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class UserListState(
    val userList: PersistentList<DomainUser>? = persistentListOf(),
    val canPaging: Boolean = false,
    val pagingState: Boolean = false,
)

