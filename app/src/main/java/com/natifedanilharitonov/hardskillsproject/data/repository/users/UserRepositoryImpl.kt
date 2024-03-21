package com.natifedanilharitonov.hardskillsproject.data.repository.users

import com.natifedanilharitonov.hardskillsproject.data.network.users.UsersSource
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import com.natifedanilharitonov.hardskillsproject.domain.repository.UsersRepository
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList

class UserRepositoryImpl(
    private val source: UsersSource
) : UsersRepository {
    override suspend fun getUsers(): PersistentList<DomainUser> {
        return source.getUsers().toPersistentList()
    }
}