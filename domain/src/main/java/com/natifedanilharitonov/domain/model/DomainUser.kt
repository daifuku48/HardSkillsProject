package com.natifedanilharitonov.domain.model

data class DomainUser(
    val gender: String,
    val name: DomainName,
    val email: String,
    val phone: String,
    val picture: DomainPicture,
)
