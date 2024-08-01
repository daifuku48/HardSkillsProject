package com.natifedanilharitonov.data.network.users.model

import com.google.gson.annotations.SerializedName
import com.natifeuaandroid.domainmodule.model.DomainPicture

data class NetworkPicture(
    @SerializedName("medium")
    val medium: String,
)

fun NetworkPicture.toDomain() : DomainPicture {
    return DomainPicture(medium = medium)
}