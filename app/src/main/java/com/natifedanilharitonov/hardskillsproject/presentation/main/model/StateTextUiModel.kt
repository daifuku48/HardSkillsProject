package com.natifedanilharitonov.hardskillsproject.presentation.main.model

import androidx.compose.runtime.Stable

@Stable
interface StateTextUiModel {
    data object Pending : StateTextUiModel

    data class Text(val text: String) : StateTextUiModel

    data object ErrorText : StateTextUiModel
}
