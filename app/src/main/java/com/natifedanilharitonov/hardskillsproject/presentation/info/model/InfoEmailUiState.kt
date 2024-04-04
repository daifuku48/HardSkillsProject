package com.natifedanilharitonov.hardskillsproject.presentation.info.model

import androidx.compose.runtime.Stable

@Stable
interface InfoEmailUiState {
    data object Pending : InfoEmailUiState
    data class Email(val email: String) : InfoEmailUiState
    data object Error : InfoEmailUiState
}