package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components.UserInfoContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserRandomSecondView(viewModel: UserRandomSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    UserInfoContainer(
        userResult = state.userResult,
        onNextScreen = viewModel::navigateToNextScreen,
        popBackScreen = viewModel::popBackScreen,
        backText = stringResource(id = R.string.back),
        isPending = state.isPending
    )
}
