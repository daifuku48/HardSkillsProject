package com.natifedanilharitonov.hardskillsproject.data.repository

import com.google.firebase.auth.FirebaseUser
import com.natifedanilharitonov.hardskillsproject.data.network.FirebaseUserSource

class FirebaseUserRepositoryImpl(
    private val source: FirebaseUserSource
) : FirebaseUserRepository {
    override suspend fun register(email: String, password: String): Boolean {
        return source.register(email, password)
    }

    override suspend fun login(email: String, password: String): Boolean {
        return source.login(email, password)
    }

    override suspend fun getUser(): FirebaseUser? {
        return source.getUser()
    }
}