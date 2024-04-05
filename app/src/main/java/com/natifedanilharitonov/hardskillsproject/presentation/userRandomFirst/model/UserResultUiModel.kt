package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model

import androidx.compose.runtime.Stable
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser

@Stable
interface UserResultUiModel {
    data object Pending : UserResultUiModel

    data class Model(
        val user: UiUser,
    ) : UserResultUiModel

    data object Error : UserResultUiModel
}
