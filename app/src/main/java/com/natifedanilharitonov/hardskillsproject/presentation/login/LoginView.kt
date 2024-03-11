package com.natifedanilharitonov.hardskillsproject.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.LoginContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginView(viewModel: LoginViewModelImpl = koinViewModel()) {
    val state by viewModel.state.collectAsState()
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
        passwordLabel = state.passwordLabel,
        colorEmailLabel = state.emailLabelColor,
        colorPasswordLabel = state.passwordLabelColor
    )
}