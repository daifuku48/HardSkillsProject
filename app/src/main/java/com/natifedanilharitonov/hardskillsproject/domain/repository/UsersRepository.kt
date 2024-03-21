package com.natifedanilharitonov.hardskillsproject.domain.repository

import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList

interface UsersRepository {
    suspend fun getUsers(): PersistentList<DomainUser>
}