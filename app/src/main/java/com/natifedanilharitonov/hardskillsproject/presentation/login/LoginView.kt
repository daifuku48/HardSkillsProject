package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.BaseErrorDialog
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.PendingScreen
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.LoginContainer
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.UserHasLoggedDialog
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginView(viewModel: LoginViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()
    LoginContainer(
        email = state.email,
        password = state.password,
        emailChanged = { email ->
            viewModel.onEmailChanged(email)
        },
        passwordChanged = { password ->
            viewModel.onPasswordChanged(password)
        },
        loginClick = viewModel::login,
        loginButtonEnabled = state.loginButtonEnabled,
        registerClick = viewModel::navigateToRegister,
        emailLabel = state.emailLabel,
        passwordLabel = state.passwordLabel
    )

    UserHasLoggedDialog(
        state = state.showUserHasLoggedDialog,
        onConfirm = viewModel::onConfirmUserHasLoggedDialog
    )

    BaseErrorDialog(
        state = state.showUserErrorLoginDialog,
        onConfirm = viewModel::onConfirmErrorUserDialog
    )

    PendingScreen(modifier = Modifier.fillMaxSize(), state = state.pending)
}