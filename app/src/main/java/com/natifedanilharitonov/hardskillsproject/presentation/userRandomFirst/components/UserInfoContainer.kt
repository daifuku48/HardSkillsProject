package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.LottieProgress
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.components.ErrorListScreen
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun UserInfoContainer(
    backText: String,
    popBackScreen: () -> Unit,
    userResult: UserResultUiModel,
    onNextScreen: () -> Unit,
) {
    when (userResult) {
        is UserResultUiModel.Error -> {
            ErrorListScreen()
        }

        is UserResultUiModel.Model -> {
            UserInfoTable(user = userResult.user)
        }

        is UserResultUiModel.Pending -> {
            LottieProgress()
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
            userResult =
                UserResultUiModel.Model(
                    user = previewUser(),
                ),
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewErrorContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult =
                UserResultUiModel.Error,
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPendingContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult = UserResultUiModel.Pending,
            onNextScreen = {},
            popBackScreen = {},
            backText = "Back",
        )
    }
}
