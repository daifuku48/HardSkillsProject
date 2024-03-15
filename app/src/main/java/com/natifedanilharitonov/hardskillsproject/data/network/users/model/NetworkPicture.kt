package com.natifedanilharitonov.hardskillsproject.data.network.users.model

import com.google.gson.annotations.SerializedName
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainPicture

data class NetworkPicture(
    @SerializedName("medium")
    val medium: String,
)

fun NetworkPicture.toDomain(): DomainPicture {
    return DomainPicture(
        medium = medium
    )
}