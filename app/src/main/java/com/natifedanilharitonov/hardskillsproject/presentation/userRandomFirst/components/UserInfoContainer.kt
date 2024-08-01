package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.LottieProgress
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.components.ErrorListScreen
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun UserInfoContainer(
    backText: String,
    popBackScreen: () -> Unit,
    userResult: UiUser?,
    onNextScreen: () -> Unit,
    isPending: Boolean,
) {
    if (isPending) {
        LottieProgress()
    } else {
        when (userResult) {
            null -> {
                ErrorListScreen()
            }

            else -> {
                UserInfoTable(user = userResult)
            }
        }
    }

    ButtonColumn(
        popBackText = backText,
        popBack = popBackScreen,
        navigateNext = onNextScreen,
        navigateNextText = stringResource(id = R.string.next_screen),
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserInfoContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult = previewUser(),
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
            isPending = false,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewErrorContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult = null,
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
            isPending = false,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPendingContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult = null,
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
            isPending = false,
        )
    }
}
