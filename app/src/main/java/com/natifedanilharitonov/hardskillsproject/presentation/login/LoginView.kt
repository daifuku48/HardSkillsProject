package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.LoginContainerView
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginView(viewModel: LoginViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    LoginContainerView(
        email = state.email,
        emailChanged = { email ->
            viewModel.onEmailChanged(email)
        },
        password = state.password,
        passwordChanged = { password ->
            viewModel.onPasswordChanged(password)
        },
        registerClick = viewModel::navigateToRegister,
        loginClick = viewModel::login,
        loginButtonEnabled = state.loginButtonEnabled,
        emailLabel = state.emailLabelValid,
        passwordLabel = state.passwordLabelValid,
        userLogDialogState = state.showUserHasLoggedDialog,
        onConfirmUserLogDialogState = viewModel::onConfirmUserHasLoggedDialog,
        errorDialogState = state.showUserErrorLoginDialog,
        onConfirmErrorDialogState = viewModel::onConfirmErrorUserDialog,
        pending = state.pending,
    )
}
