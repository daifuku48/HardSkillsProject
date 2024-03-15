package com.natifedanilharitonov.hardskillsproject.data.repository.users

import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

interface UsersRepository {
    suspend fun getUsers(): PersistentList<DomainUser>
}