package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UiUser

@Composable
fun UserInfoTable(user: UiUser) {
    Column {
        RandomUserImage(image = user.picture.medium)

        TableInfoColumn(
            name = user.name,
            email = user.email,
            gender = user.gender,
            phone = user.phone
        )
    }
}

