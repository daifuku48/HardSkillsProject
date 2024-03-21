package com.natifedanilharitonov.hardskillsproject.data.network.firebase

import com.google.firebase.auth.FirebaseUser

interface FirebaseUserSource {
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean
    suspend fun getUser(): FirebaseUser?
    fun signOut()
}