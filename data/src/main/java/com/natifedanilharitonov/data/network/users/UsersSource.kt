package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkUser

interface UsersSource {
    suspend fun getUsers(): List<NetworkUser>

    suspend fun getUser(): NetworkUser?
}
