package com.natifedanilharitonov.hardskillsproject.data.repository.firebase

import com.google.firebase.auth.FirebaseUser
import com.natifedanilharitonov.hardskillsproject.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.hardskillsproject.domain.repository.FirebaseUserRepository

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

    override fun signOut() {
        source.signOut()
    }
}