package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.BaseErrorDialog
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.PendingScreen
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun LoginContainerView(
    email: String,
    emailChanged: (String) -> Unit,
    password: String,
    passwordChanged: (String) -> Unit,
    registerClick: () -> Unit,
    loginClick: () -> Unit,
    loginButtonEnabled: Boolean,
    emailLabel: Boolean,
    passwordLabel: Boolean,
    userLogDialogState: Boolean,
    onConfirmUserLogDialogState: () -> Unit,
    errorDialogState: Boolean,
    onConfirmErrorDialogState: () -> Unit,
    pending: Boolean,
) {
    LoginFields(
        email = email,
        password = password,
        emailChanged = { emailText ->
            emailChanged(emailText)
        },
        passwordChanged = { passwordText ->
            passwordChanged(passwordText)
        },
        loginClick = loginClick,
        loginButtonEnabled = loginButtonEnabled,
        registerClick = registerClick,
        emailLabel = emailLabel,
        passwordLabel = passwordLabel,
    )

    UserHasLoggedDialog(
        state = userLogDialogState,
        onConfirm = onConfirmUserLogDialogState,
    )

    BaseErrorDialog(
        state = errorDialogState,
        onConfirm = onConfirmErrorDialogState,
    )

    PendingScreen(modifier = Modifier.fillMaxSize(), state = pending)
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewLogin() {
    HardSkillsProjectTheme {
        LoginContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12345678",
            passwordChanged = {},
            emailLabel = true,
            passwordLabel = true,
            pending = false,
            userLogDialogState = false,
            onConfirmUserLogDialogState = {},
            onConfirmErrorDialogState = {},
            errorDialogState = false,
            loginButtonEnabled = true,
            loginClick = {},
            registerClick = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginUserDialog() {
    HardSkillsProjectTheme {
        LoginContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12345678",
            passwordChanged = {},
            emailLabel = true,
            passwordLabel = true,
            pending = false,
            userLogDialogState = true,
            onConfirmUserLogDialogState = {},
            onConfirmErrorDialogState = {},
            errorDialogState = false,
            loginButtonEnabled = true,
            loginClick = {},
            registerClick = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginErrorDialog() {
    HardSkillsProjectTheme {
        LoginContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12345678",
            passwordChanged = {},
            emailLabel = true,
            passwordLabel = true,
            pending = false,
            userLogDialogState = false,
            onConfirmUserLogDialogState = {},
            onConfirmErrorDialogState = {},
            errorDialogState = true,
            loginButtonEnabled = true,
            loginClick = {},
            registerClick = {},
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPending() {
    HardSkillsProjectTheme {
        LoginContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12345678",
            passwordChanged = {},
            emailLabel = true,
            passwordLabel = true,
            pending = true,
            userLogDialogState = false,
            onConfirmUserLogDialogState = {},
            onConfirmErrorDialogState = {},
            errorDialogState = false,
            loginButtonEnabled = true,
            loginClick = {},
            registerClick = {},
        )
    }
}
