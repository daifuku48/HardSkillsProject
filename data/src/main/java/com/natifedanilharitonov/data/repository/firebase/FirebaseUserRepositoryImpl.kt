package com.natifedanilharitonov.data.repository.firebase

import com.natifedanilharitonov.data.network.firebase.FirebaseUserSource
import com.natifedanilharitonov.data.network.firebase.model.toDomain
import com.natifeuaandroid.domainmodule.model.DomainFirebaseUser
import com.natifeuaandroid.domainmodule.repository.FirebaseUserRepository


internal class FirebaseUserRepositoryImpl(
    private val source: FirebaseUserSource,
) : FirebaseUserRepository {
    override suspend fun register(
        email: String,
        password: String,
    ): Boolean {
        return source.register(email, password)
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Boolean {
        return source.login(email, password)
    }

    override suspend fun getUser(): DomainFirebaseUser? {
        return source.getUser()?.toDomain()
    }

    override fun signOut() {
        source.signOut()
    }
}
