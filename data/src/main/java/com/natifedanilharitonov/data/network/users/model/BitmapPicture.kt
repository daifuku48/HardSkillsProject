package com.natifedanilharitonov.data.network.users.model

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.model.DomainPicture

data class BitmapPicture(
    val medium: Bitmap,
)

fun BitmapPicture.toDomain(): DomainPicture {
    return DomainPicture(
        medium = medium,
    )
}
