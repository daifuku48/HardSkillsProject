package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkUser

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