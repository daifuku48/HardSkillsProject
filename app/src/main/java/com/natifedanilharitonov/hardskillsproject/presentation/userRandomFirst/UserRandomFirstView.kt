package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components.UserInfoContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserRandomFirstView(viewModel: UserRandomFirstViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    UserInfoContainer(
        userResult = state.userResult,
        onNextScreen = viewModel::navigateToNextScreen,
        backText = stringResource(id = R.string.back_to_main_screen),
        popBackScreen = viewModel::popToMain,
    )
}
