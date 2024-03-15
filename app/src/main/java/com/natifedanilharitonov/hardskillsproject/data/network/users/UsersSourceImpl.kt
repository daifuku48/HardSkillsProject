package com.natifedanilharitonov.hardskillsproject.data.network.users

import com.natifedanilharitonov.hardskillsproject.data.network.users.model.toDomain
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser

class UsersSourceImpl(
    private val instance: UsersRetrofitInstance,
) : UsersSource {
    override suspend fun getUsers(): List<DomainUser> {
        return try {
            instance.getUsers().users.map { it.toDomain() }
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }
}