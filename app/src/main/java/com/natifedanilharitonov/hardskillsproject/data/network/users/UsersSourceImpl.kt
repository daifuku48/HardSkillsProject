package com.natifedanilharitonov.hardskillsproject.data.network.users

import com.natifedanilharitonov.hardskillsproject.data.network.users.model.NetworkUser
import com.natifedanilharitonov.hardskillsproject.data.network.users.model.toDomain
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser

class UsersSourceImpl(
    private val instance: UsersRetrofitInstance,
) : UsersSource {
    override suspend fun getUsers(): List<NetworkUser> {
        return try {
            instance.getUsers().users
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
    }
}