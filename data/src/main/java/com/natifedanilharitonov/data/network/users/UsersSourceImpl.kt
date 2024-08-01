package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkUser

internal class UsersSourceImpl(
    private val instance: UsersRetrofitInstance,
) : UsersSource {
    override suspend fun getUsers(): List<NetworkUser> {
        val users = instance.getUsers().users
        return users
    }

    override suspend fun getUser(): NetworkUser? {
        return try {
            val user = instance.getUser()
            return user.users.first()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
