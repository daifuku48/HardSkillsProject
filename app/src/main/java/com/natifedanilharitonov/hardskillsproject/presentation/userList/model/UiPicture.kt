package com.natifedanilharitonov.hardskillsproject.presentation.userList.model

import com.natifeuaandroid.domainmodule.model.DomainPicture

data class UiPicture(
    val medium: String,
)

fun DomainPicture.toUi(): UiPicture {
    return UiPicture(
        medium = medium,
    )
}
