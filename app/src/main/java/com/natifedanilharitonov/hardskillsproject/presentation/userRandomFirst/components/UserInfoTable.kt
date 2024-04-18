package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.IMAGE_TAG

@Composable
fun UserInfoTable(user: UiUser) {
    Column {
        RandomUserImage(image = user.picture.medium, modifier = Modifier.testTag(IMAGE_TAG))

        TableInfoColumn(
            name = user.name,
            email = user.email,
            gender = user.gender,
            phone = user.phone,
        )
    }
}
