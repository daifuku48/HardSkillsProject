package com.natifedanilharitonov.data.network.users

import com.natifedanilharitonov.data.network.users.model.NetworkUserBitmap

interface UsersSource {
    suspend fun getUsers(): List<NetworkUserBitmap>

    suspend fun getUser(): NetworkUserBitmap?
}
