package com.natifedanilharitonov.data.network.firebase

import com.natifedanilharitonov.data.network.firebase.model.FirebaseUserNetwork

interface FirebaseUserSource {
    suspend fun register(
        email: String,
        password: String,
    ): Boolean

    suspend fun login(
        email: String,
        password: String,
    ): Boolean

    suspend fun getUser(): FirebaseUserNetwork?

    fun signOut()
}
