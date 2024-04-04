package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.LottieProgress
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.components.ErrorListScreen
import com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.model.UserResultUiModel

@Composable
fun UserInfoContainer(userResult: UserResultUiModel, onNextScreen: () -> Unit) {
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
