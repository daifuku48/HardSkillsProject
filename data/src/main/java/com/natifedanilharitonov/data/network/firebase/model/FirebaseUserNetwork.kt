package com.natifedanilharitonov.data.network.firebase.model

import com.natifedanilharitonov.domain.model.DomainFirebaseUser

data class FirebaseUserNetwork(
    val email: String,
)

fun FirebaseUserNetwork.toDomain(): DomainFirebaseUser {
    return DomainFirebaseUser(email = email)
}
