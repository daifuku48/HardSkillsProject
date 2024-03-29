package com.natifedanilharitonov.hardskillsproject.presentation.info.model

interface InfoEmailUiState {
    data object Pending : InfoEmailUiState
    data class Email(val email: String) : InfoEmailUiState
    data object Error : InfoEmailUiState
}