package com.natifedanilharitonov.hardskillsproject.presentation.user_list.model

import com.natifedanilharitonov.domain.model.DomainPicture

data class UiPicture(
    val medium: String
)

fun DomainPicture.toUi(): UiPicture {
    return UiPicture(
        medium = medium
    )
}