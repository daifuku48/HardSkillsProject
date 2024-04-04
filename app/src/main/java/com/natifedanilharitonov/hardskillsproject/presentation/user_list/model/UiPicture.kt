package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import android.graphics.Bitmap
import com.natifedanilharitonov.domain.model.DomainPicture


data class UiPicture(
    val medium: Bitmap
)

fun DomainPicture.toUi(): UiPicture {
    return UiPicture(
        medium = medium
    )
}