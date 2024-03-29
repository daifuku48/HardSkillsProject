package com.natifedanilharitonov.hardskillsproject.presentation.registration

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.BaseErrorDialog
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.PendingScreen
import com.natifedanilharitonov.hardskillsproject.presentation.registration.components.RegistrationContainer
import com.natifedanilharitonov.hardskillsproject.presentation.registration.components.UserHasRegisteredDialog
import org.koin.androidx.compose.koinViewModel


@Composable
fun RegistrationView(viewModel: RegistrationViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()
    RegistrationContainer(
        email = state.email,
        emailChanged = { email -> viewModel.emailChanged(email) },
        password = state.password,
        passwordChanged = { password -> viewModel.passwordChanged(password) },
        registerClick = { viewModel.register() },
        loginClick = { viewModel.navigateToLogin() },
        emailLabel = state.emailLabel,
        passwordLabel = state.passwordLabel,
        registerButtonEnabled = state.registerButtonEnabled
    )

    UserHasRegisteredDialog(
        state = state.showUserHasLoggedDialog,
        onConfirm = viewModel::onConfirmUserRegisteredDialog
    )

    BaseErrorDialog(
        state = state.showUserErrorRegisterDialog,
        onConfirm = viewModel::onConfirmErrorDialog
    )

    PendingScreen(
        modifier = Modifier
            .fillMaxSize(),
        state = state.pending
    )
}