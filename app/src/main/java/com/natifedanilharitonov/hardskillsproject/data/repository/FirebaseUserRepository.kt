package com.natifedanilharitonov.hardskillsproject.data.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseUserRepository {
    suspend fun register(email: String, password: String): Boolean
    suspend fun login(email: String, password: String): Boolean
    suspend fun getUser(): FirebaseUser?
}