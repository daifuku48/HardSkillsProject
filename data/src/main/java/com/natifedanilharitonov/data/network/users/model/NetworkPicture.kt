package com.natifedanilharitonov.data.network.users.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class NetworkPicture(
    @SerializedName("medium")
    val medium: String,
)

fun NetworkPicture.toBitmap(bitmap: Bitmap): BitmapPicture {
    return BitmapPicture(
        medium = bitmap
    )
}