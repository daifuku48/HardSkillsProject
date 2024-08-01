package com.natifedanilharitonov.hardskillsproject.presentation.userList.model

import com.natifeuaandroid.domainmodule.model.DomainUser


data class UiUser(
    val gender: String,
    val name: UiName,
    val email: String,
    val phone: String,
    val picture: UiPicture,
)

fun DomainUser.toUi(): UiUser {
    return UiUser(
        gender = gender,
        name = name.toUi(),
        email = email,
        phone = phone,
        picture = picture.toUi(),
    )
}
