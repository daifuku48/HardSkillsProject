package com.natifedanilharitonov.hardskillsproject.presentation.login.model

import androidx.compose.runtime.Stable

@Stable
interface EmailLabelState {
    data object ValidEmailLabel : EmailLabelState

    data object ErrorEmailLabel : EmailLabelState
}
