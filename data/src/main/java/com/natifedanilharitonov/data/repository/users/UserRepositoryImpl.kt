package com.natifedanilharitonov.data.repository.users

import com.natifedanilharitonov.data.network.users.UsersSource
import com.natifedanilharitonov.data.network.users.model.toDomain
import com.natifedanilharitonov.domain.model.DomainUser
import com.natifedanilharitonov.domain.repository.UsersRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class UserRepositoryImpl(
    private val source: UsersSource
) : UsersRepository {
    override suspend fun getUsers(): PersistentList<DomainUser> {
        return source.getUsers().map { it.toDomain() }.toPersistentList()
    }
}