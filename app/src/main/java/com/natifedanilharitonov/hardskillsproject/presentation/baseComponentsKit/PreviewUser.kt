package com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiName
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiPicture
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser

@Composable
fun previewUser(): UiUser =
    remember {
        UiUser(
            gender = "male",
            email = "mock@gmail.com",
            name = UiName(title = "Ms.", first = "Name", last = "Noname"),
            phone = "+380997232718",
            picture = UiPicture(""),
        )
    }
