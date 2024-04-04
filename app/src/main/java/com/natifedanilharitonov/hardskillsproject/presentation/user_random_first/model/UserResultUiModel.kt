package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model

import androidx.compose.runtime.Stable
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UiUser

@Stable
interface UserResultUiModel {
    data object Pending : UserResultUiModel
    data class Model(
        val user: UiUser
    ) : UserResultUiModel

    data object Error : UserResultUiModel
}