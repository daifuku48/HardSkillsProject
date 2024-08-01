package com.natifeuaandroid.domainmodule.repository

import com.natifeuaandroid.domainmodule.model.DomainFirebaseUser


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
