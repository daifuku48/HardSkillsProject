package com.natifedanilharitonov.data.network.users.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

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

fun NetworkUser.toUserWithBitmap(medium: Bitmap): NetworkUserBitmap {
    return NetworkUserBitmap(
        gender = gender,
        name = name,
        email = email,
        phone = phone,
        picture = picture.toBitmap(medium),
    )
}
