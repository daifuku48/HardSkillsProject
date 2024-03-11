package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiState

data class RegistrationState(
    val email: String = "",
    val password: String = "",
    val emailLabel: String = "",
    val passwordLabel: String = "",
    val emailLabelColor: Color = Color.Black,
    val passwordLabelColor: Color = Color.Black,
    val pending: Boolean = false,
    val registerButtonEnabled: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorRegisterDialog: Boolean = false
) : UiState