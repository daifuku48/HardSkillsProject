package com.natifedanilharitonov.domain.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseUserRepository {
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean
    suspend fun getUser(): FirebaseUser?
    fun signOut()
}