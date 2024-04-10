package com.natifedanilharitonov.domain.repository

import com.natifedanilharitonov.domain.model.DomainFirebaseUser

interface FirebaseUserRepository {
    suspend fun register(
        email: String,
        password: String,
    ): Boolean

    suspend fun login(
        email: String,
        password: String,
    ): Boolean

    suspend fun getUser(): DomainFirebaseUser?

    fun signOut()
}
