package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.ui.graphics.Color
import com.natifedanilharitonov.hardskillsproject.core.UiState

data class RegistrationState(
    val nickname: String = "",
    val email: String = "",
    val password: String = "",
    val nicknameLabel: String = "",
    val emailLabel: String = "",
    val passwordLabel: String = "",
    val nicknameLabelColor: Color = Color.Black,
    val emailLabelColor: Color = Color.Black,
    val passwordLabelColor: Color = Color.Black,
    val pending: Boolean = false,
    val showUserHasLoggedDialog: Boolean = false,
    val showUserErrorLoginDialog: Boolean = false
) : UiState