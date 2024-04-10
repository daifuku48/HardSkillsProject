package com.natifedanilharitonov.data.network.firebase

import com.google.firebase.auth.FirebaseAuth
import com.natifedanilharitonov.data.network.firebase.model.FirebaseUserNetwork
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class FirebaseUserSourceImpl(
    private val auth: FirebaseAuth,
) : FirebaseUserSource {
    override suspend fun register(
        email: String,
        password: String,
    ): Boolean {
        return suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener {
                    continuation.resume(false)
                }
        }
    }

    override suspend fun login(
        email: String,
        password: String,
    ): Boolean {
        return suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener {
                    continuation.resume(false)
                }
        }
    }

    override suspend fun getUser(): FirebaseUserNetwork? {
        val user = auth.currentUser
        return if (user != null) {
            FirebaseUserNetwork(user.email ?: "")
        } else {
            null
        }
    }

    override fun signOut() {
        auth.signOut()
    }
}
