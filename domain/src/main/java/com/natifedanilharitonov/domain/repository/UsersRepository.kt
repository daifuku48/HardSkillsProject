package com.natifedanilharitonov.domain.repository

import com.natifedanilharitonov.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

interface UsersRepository {
    suspend fun getUsers(): PersistentList<DomainUser>

    suspend fun getUser(): DomainUser?
}
