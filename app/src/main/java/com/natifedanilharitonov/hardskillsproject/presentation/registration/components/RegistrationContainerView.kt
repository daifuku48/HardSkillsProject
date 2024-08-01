package com.natifedanilharitonov.hardskillsproject.presentation.registration.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.BaseErrorDialog
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.PendingScreen
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun RegistrationContainerView(
    email: String,
    emailChanged: (String) -> Unit,
    password: String,
    passwordChanged: (String) -> Unit,
    registerClick: () -> Unit,
    loginClick: () -> Unit,
    registerButtonEnabled: Boolean,
    userLogDialogState: Boolean,
    onConfirmUserLogDialogState: () -> Unit,
    errorDialogState: Boolean,
    onConfirmErrorDialogState: () -> Unit,
    pending: Boolean,
    passwordLabel: Boolean,
    emailLabel: Boolean
) {
    RegistrationFields(
        email = email,
        emailChanged = { textEmail -> emailChanged(textEmail) },
        password = password,
        passwordChanged = { textPassword -> passwordChanged(textPassword) },
        registerClick = registerClick,
        loginClick = loginClick,
        emailLabel = emailLabel,
        passwordLabel = passwordLabel,
        registerButtonEnabled = registerButtonEnabled,
    )

    UserHasRegisteredDialog(
        state = userLogDialogState,
        onConfirm = onConfirmUserLogDialogState,
    )

    BaseErrorDialog(
        state = errorDialogState,
        onConfirm = onConfirmErrorDialogState,
    )

    PendingScreen(
        modifier =
        Modifier
            .fillMaxSize(),
        state = pending,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewRegistration() {
    HardSkillsProjectTheme {
        RegistrationContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12344",
            passwordChanged = {},
            registerClick = { },
            loginClick = { },
            registerButtonEnabled = true,
            emailLabel = true,
            passwordLabel = false,
            userLogDialogState = false,
            onConfirmUserLogDialogState = { },
            errorDialogState = false,
            onConfirmErrorDialogState = { },
            pending = false,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUserLogRegistration() {
    HardSkillsProjectTheme {
        RegistrationContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12344",
            passwordChanged = {},
            registerClick = { },
            loginClick = { },
            registerButtonEnabled = true,
            emailLabel = true,
            passwordLabel = false,
            userLogDialogState = true,
            onConfirmUserLogDialogState = { },
            errorDialogState = false,
            onConfirmErrorDialogState = { },
            pending = false,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewErrorLogRegistration() {
    HardSkillsProjectTheme {
        RegistrationContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12344",
            passwordChanged = {},
            registerClick = { },
            loginClick = { },
            registerButtonEnabled = true,
            emailLabel = true,
            passwordLabel = false,
            userLogDialogState = false,
            onConfirmUserLogDialogState = { },
            errorDialogState = true,
            onConfirmErrorDialogState = { },
            pending = false,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewPendingRegistration() {
    HardSkillsProjectTheme {
        RegistrationContainerView(
            email = "mock@gmail.com",
            emailChanged = {},
            password = "12344",
            passwordChanged = {},
            registerClick = { },
            loginClick = { },
            registerButtonEnabled = true,
            emailLabel = true,
            passwordLabel = false,
            userLogDialogState = false,
            onConfirmUserLogDialogState = { },
            errorDialogState = false,
            onConfirmErrorDialogState = { },
            pending = true,
        )
    }
}
