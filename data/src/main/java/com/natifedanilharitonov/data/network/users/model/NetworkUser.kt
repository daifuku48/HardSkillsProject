package com.natifedanilharitonov.data.network.users.model

import com.google.gson.annotations.SerializedName
import com.natifeuaandroid.domainmodule.model.DomainUser

data class NetworkUser(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: NetworkName,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: NetworkPicture,
)

fun NetworkUser.toDomain() : DomainUser {
    return DomainUser(
        gender = gender,
        name = name.toDomain(),
        email = email,
        phone = phone,
        picture = picture.toDomain()
    )
}