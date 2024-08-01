package com.natifedanilharitonov.data.repository.users

import com.natifedanilharitonov.data.network.users.UsersSource
import com.natifedanilharitonov.data.network.users.model.toDomain
import com.natifeuaandroid.domainmodule.model.DomainUser
import com.natifeuaandroid.domainmodule.repository.UsersRepository

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

internal class UserRepositoryImpl(
    private val source: UsersSource,
) : UsersRepository {
    override suspend fun getUsers(): PersistentList<DomainUser> {
        return source.getUsers().map { it.toDomain() }.toPersistentList()
    }

    override suspend fun getUser(): DomainUser? {
        return source.getUser()?.toDomain()
    }
}
