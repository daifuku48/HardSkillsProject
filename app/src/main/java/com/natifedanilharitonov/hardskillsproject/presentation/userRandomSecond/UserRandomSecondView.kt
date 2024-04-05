package com.natifedanilharitonov.hardskillsproject.presentation.userRandomSecond

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components.UserInfoContainer
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserRandomSecondView(viewModel: UserRandomSecondViewModelImpl = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()

    UserInfoContainer(userResult = state.userResult, onNextScreen = viewModel::navigateToNextScreen)
}
