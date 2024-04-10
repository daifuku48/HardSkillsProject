package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.LottieProgress
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.userList.components.ErrorListScreen
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.model.UserResultUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun UserInfoContainer(
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

    MainButton(text = stringResource(id = R.string.next_screen), onClick = onNextScreen)
}

@Preview
@Composable
fun PreviewUserInfoContainer() {
    HardSkillsProjectTheme {
        UserInfoContainer(
            userResult =
                UserResultUiModel.Model(
                    user = previewUser(),
                ),
            onNextScreen = {},
        )
    }
}
