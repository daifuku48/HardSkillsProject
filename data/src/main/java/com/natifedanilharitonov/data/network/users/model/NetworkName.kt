package com.natifedanilharitonov.data.network.users.model

import com.google.gson.annotations.SerializedName
import com.natifedanilharitonov.domain.model.DomainName

data class NetworkName(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

fun NetworkName.toDomain(): DomainName {
    return DomainName(
        title = title,
        first = first,
        last = last
    )
}