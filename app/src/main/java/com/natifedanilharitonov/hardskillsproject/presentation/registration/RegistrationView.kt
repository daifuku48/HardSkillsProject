package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.registration.components.RegistrationContainerView
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegistrationView(viewModel: RegistrationViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    RegistrationContainerView(
        email = state.email,
        emailChanged = { email -> viewModel.emailChanged(email) },
        password = state.password,
        passwordChanged = { password -> viewModel.passwordChanged(password) },
        registerClick = { viewModel.register() },
        loginClick = { viewModel.navigateToLogin() },
        emailLabel = state.emailLabel,
        passwordLabel = state.passwordLabel,
        registerButtonEnabled = state.registerButtonEnabled,
        errorDialogState = state.showUserErrorRegisterDialog,
        onConfirmErrorDialogState = viewModel::onConfirmErrorDialog,
        userLogDialogState = state.showUserHasLoggedDialog,
        onConfirmUserLogDialogState = viewModel::onConfirmUserRegisteredDialog,
        pending = state.pending,
    )
}
