package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiState

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailLabel: String = "",
    val passwordLabel: String = "",
    val emailLabelColor: Color = Color.Black,
    val passwordLabelColor: Color = Color.Black,
    val pending: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false,
    val loginButtonEnabled: Boolean = false
) : UiState