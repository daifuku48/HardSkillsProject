package com.natifedanilharitonov.hardskillsproject.data.network

interface FirebaseUserSource {
    suspend fun register(nickname: String, email: String, password: String)
    suspend fun login(email: String, password: String)
}