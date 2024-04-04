package com.natifedanilharitonov.data.network.users.model

import com.natifedanilharitonov.domain.model.DomainUser

class NetworkUserBitmap(
    val gender: String,
    val name: NetworkName,
    val email: String,
    val phone: String,
    val picture: BitmapPicture
)

fun NetworkUserBitmap.toDomain(): DomainUser {
    return DomainUser(
        gender = gender,
        name = name.toDomain(),
        email = email,
        phone = phone,
        picture = picture.toDomain()
    )
}