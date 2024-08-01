package com.natifeuaandroid.domainmodule.repository

import com.natifeuaandroid.domainmodule.model.DomainUser
import kotlinx.collections.immutable.PersistentList


interface UsersRepository {
    suspend fun getUsers(): PersistentList<DomainUser>

    suspend fun getUser(): DomainUser?
}
