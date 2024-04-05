package com.natifedanilharitonov.hardskillsproject.presentation.login.model

import androidx.compose.runtime.Stable

@Stable
interface PasswordLabelState {
    data object ValidPassword : PasswordLabelState

    data object ErrorPassword : PasswordLabelState
}
